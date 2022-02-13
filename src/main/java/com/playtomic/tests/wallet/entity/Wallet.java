package com.playtomic.tests.wallet.entity;

import com.playtomic.tests.wallet.enummurated.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WALLET")
public class Wallet {

    @Id
    @GeneratedValue
    private UUID id;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Currency currency;

    private BigDecimal balance;

    @NonNull
    private String creditCardNumber;
}