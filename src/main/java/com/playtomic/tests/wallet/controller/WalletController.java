package com.playtomic.tests.wallet.controller;

import com.playtomic.tests.wallet.model.PaymentDto;
import com.playtomic.tests.wallet.model.WalletDto;
import com.playtomic.tests.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wallet")
public class WalletController {

    private final WalletService walletService;

    @GetMapping("/{walletId}")
    public ResponseEntity<WalletDto> getWalletById(@PathVariable("walletId") UUID walletId) {
        return ResponseEntity.ok(walletService.getWalletById(walletId));
    }

    @PostMapping("/save")
    public ResponseEntity<WalletDto> save(@RequestBody WalletDto walletDto) {
        return ResponseEntity.ok(walletService.save(walletDto));
    }

    @PatchMapping("/add-amount")
    public ResponseEntity<WalletDto> topUptoWallet(@RequestBody PaymentDto paymentDto) {
        return ResponseEntity.ok(walletService.addAmountToWallet(paymentDto));
    }

    @PatchMapping("/payment")
    public ResponseEntity<WalletDto> payment(@RequestBody PaymentDto paymentDto) {
        return ResponseEntity.ok(walletService.payment(paymentDto));
    }

    @PatchMapping("/payment/refund/{id}")
    public ResponseEntity<WalletDto> refundPayment(@RequestBody UUID id) {
        return ResponseEntity.ok(walletService.refund(id));
    }
}
