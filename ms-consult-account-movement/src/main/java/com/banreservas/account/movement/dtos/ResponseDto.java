package com.banreservas.account.movement.dtos;

public class ResponseDto {

    private ResponseHeaderDto header;
    private AccountMovementResponse accountMovementResponse;

    public ResponseDto(ResponseHeaderDto header, AccountMovementResponse accountMovementResponse) {
        this.header = header;
        this.accountMovementResponse = accountMovementResponse;
    }

    public ResponseHeaderDto getHeader() {
        return header;
    }

    public void setHeader(ResponseHeaderDto header) {
        this.header = header;
    }

    public AccountMovementResponse getAccountMovementResponse() {
        return accountMovementResponse;
    }

    public void setAccountMovementResponse(AccountMovementResponse accountMovementResponse) {
        this.accountMovementResponse = accountMovementResponse;
    }
}
