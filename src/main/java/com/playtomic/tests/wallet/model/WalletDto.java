package com.playtomic.tests.wallet.model;

import com.playtomic.tests.wallet.enummurated.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletDto {

    private UUID id;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @NonNull
    private BigDecimal balance = BigDecimal.ZERO;

    private String creditCardNumber;
}
