package com.playtomic.tests.wallet.service;

import com.playtomic.tests.wallet.entity.Wallet;
import com.playtomic.tests.wallet.model.PaymentDto;
import com.playtomic.tests.wallet.model.WalletDto;

import java.util.UUID;

public interface WalletService {

    WalletDto getWalletById(UUID id);

    WalletDto addAmountToWallet(PaymentDto paymentDto);

    WalletDto payment(PaymentDto paymentDto);

    WalletDto refund(UUID paymentId);

    WalletDto save(WalletDto saveDto);
}
