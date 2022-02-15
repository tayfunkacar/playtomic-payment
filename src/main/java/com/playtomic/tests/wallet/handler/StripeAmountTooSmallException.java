package com.playtomic.tests.wallet.handler;

public class StripeAmountTooSmallException extends StripeServiceException {
    public StripeAmountTooSmallException(String hataMesaji) {
        super(hataMesaji);
    }
}
