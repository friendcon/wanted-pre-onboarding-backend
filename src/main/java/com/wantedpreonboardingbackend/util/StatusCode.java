package com.wantedpreonboardingbackend.util;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StatusCode {
    SUCCESS("200", "OK"),
    BAD_REQUEST("400", "BAD REQUEST");

    String code;
    String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
