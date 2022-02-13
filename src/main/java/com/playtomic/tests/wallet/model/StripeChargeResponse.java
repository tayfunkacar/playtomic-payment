package com.playtomic.tests.wallet.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class StripeChargeResponse {

    @JsonProperty("id")
    public UUID paymentId;

    @JsonProperty("amount")
    public BigDecimal amount;

    public StripeChargeResponse(UUID paymentId, BigDecimal amount) {
        this.paymentId = paymentId;
        this.amount = amount;
    }
}
