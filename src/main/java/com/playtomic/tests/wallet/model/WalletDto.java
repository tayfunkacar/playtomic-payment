package com.playtomic.tests.wallet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletDto {

    private UUID id;

    private UUID userId;

    private BigDecimal balance = BigDecimal.ZERO;

    private String creditCardNumber;
}
