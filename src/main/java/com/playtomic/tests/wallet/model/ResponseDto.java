package com.playtomic.tests.wallet.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponseDto {

    private int code;

    private String message;

    private LocalDate timestamp;

    public ResponseDto(int code, String message) {
        this.code = code;
        this.timestamp = LocalDate.now();
        this.message = message;
    }
}