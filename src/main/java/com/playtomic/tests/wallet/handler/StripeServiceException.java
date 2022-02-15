package com.playtomic.tests.wallet.handler;

public class StripeServiceException extends RuntimeException {
    public StripeServiceException(String hataMesaji) {
        super(hataMesaji);
    }
}
