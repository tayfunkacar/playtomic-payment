package com.playtomic.tests.wallet.service;

import com.playtomic.tests.wallet.entity.Payment;
import com.playtomic.tests.wallet.entity.Wallet;
import com.playtomic.tests.wallet.mapper.WalletMapper;
import com.playtomic.tests.wallet.model.PaymentDto;
import com.playtomic.tests.wallet.model.WalletDto;
import com.playtomic.tests.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;
    private final WalletMapper walletMapper;
    private final PaymentService paymentService;

    @Transactional(readOnly = true)
    public WalletDto getWalletById(UUID id) {
        Wallet wallet = findByIdWallet(id);
        return walletMapper.toDto(wallet);
    }


    @Transactional
    public WalletDto addAmountToWallet(PaymentDto paymentDto) {
        Wallet wallet = findByIdWallet(paymentDto.getWallet().getId());
        wallet.setBalance(wallet.getBalance().add(paymentDto.getAmount()));
        wallet = walletRepository.save(wallet);
        return walletMapper.toDto(wallet);
    }

    @Transactional
    public WalletDto payment(PaymentDto paymentDto) {
        Wallet wallet = findByIdWallet(paymentDto.getWallet().getId());
        wallet.setBalance(wallet.getBalance().subtract(paymentDto.getAmount()));
        wallet = walletRepository.save(wallet);
        WalletDto walletDto = walletMapper.toDto(wallet);
        paymentDto.setWallet(walletDto);
        paymentService.savePayment(paymentDto);
        return walletMapper.toDto(wallet);
    }

    @Transactional
    public WalletDto refund(UUID paymentId) {
        Payment payment = paymentService.findByIdWallet(paymentId);
        Wallet wallet = payment.getWallet();
        wallet.setBalance(payment.getWallet().getBalance().add(payment.getAmount()));
        wallet = walletRepository.save(wallet);
        paymentService.cancelPayment(payment);
        return walletMapper.toDto(wallet);
    }

    private Wallet findByIdWallet(UUID id) {
        return walletRepository.findById(id).orElseThrow(() -> new RuntimeException("No found wallet record"));
    }

    @Transactional
    public WalletDto save(WalletDto saveDto) {
        Wallet wallet = walletMapper.toEntity(saveDto);
        wallet = walletRepository.save(wallet);
        return walletMapper.toDto(wallet);
    }

}
