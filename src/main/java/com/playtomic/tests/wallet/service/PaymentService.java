package com.playtomic.tests.wallet.service;

import com.playtomic.tests.wallet.entity.Payment;
import com.playtomic.tests.wallet.model.PaymentDto;

import java.util.UUID;

public interface PaymentService {

    void savePayment(PaymentDto payment);

    void cancelPayment(Payment payment);

    Payment findByIdWallet(UUID id);
}
