
package com.playtomic.tests.wallet.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {

    @NonNull
    private UUID id;

    @NonNull
    private WalletDto wallet;

    @NonNull
    private BigDecimal amount;
}