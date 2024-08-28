package com.banreservas.account.movement.services;

import com.banreservas.account.movement.dtos.AccountMovementRequest;
import com.banreservas.account.movement.dtos.AccountMovementResponse;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.core.HttpHeaders;

public interface IServiceMovementAccount {

    Uni<AccountMovementResponse> getAccountDetailsMovements(AccountMovementRequest accountMovementRequest, HttpHeaders httpHeaders);

}
