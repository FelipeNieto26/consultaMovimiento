package com.banreservas.account.movement.dtos;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class ResponseHeaderDto {

    private int responseCode;
    private String responseMessage;

    // Constructor
    public ResponseHeaderDto(int responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    //Getters y Setters
    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
