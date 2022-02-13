package com.playtomic.tests.wallet.service;

import com.playtomic.tests.wallet.entity.Payment;
import com.playtomic.tests.wallet.mapper.PaymentMapper;
import com.playtomic.tests.wallet.model.PaymentDto;
import com.playtomic.tests.wallet.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final StripeService stripeService;

    @Transactional
    public void savePayment(PaymentDto saveDto) {
        Payment payment = paymentMapper.toEntity(saveDto);
        UUID paymentId = stripeService.charge(payment.getWallet().getCreditCardNumber(), payment.getAmount());
        payment.setPaymentId(paymentId);
        paymentRepository.save(payment);
    }

    @Transactional
    public void cancelPayment(Payment payment) {
        stripeService.refund(payment.getPaymentId().toString());
        payment.setIsRefunded(Boolean.TRUE);
        paymentRepository.save(payment);
    }

    @Transactional(readOnly = true)
    public Payment findByIdWallet(UUID id) {
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("No found payment record"));
    }
}
