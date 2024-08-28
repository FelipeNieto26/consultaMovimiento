package com.banreservas.account.movement.resources;

import com.banreservas.account.movement.dtos.AccountMovementRequest;
import com.banreservas.account.movement.dtos.ResponseDto;
import com.banreservas.account.movement.dtos.ResponseHeaderDto;
import com.banreservas.account.movement.services.IServiceMovementAccount;
import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/v1")
@ApplicationScoped
//@Authenticated
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovementAccountResource {

    Logger logger = LoggerFactory.getLogger(MovementAccountResource.class);

    @Inject
    IServiceMovementAccount iServiceMovementAccount;

    @POST
    @Path("/getAccountDetailsMovements")
    public Uni<ResponseDto> getAccountDetailsMovements(@Valid AccountMovementRequest accountMovementRequest,
                                                       @Context HttpHeaders httpHeaders) {
        if (!isCompleteHeaders(httpHeaders)) return getError(400, "Headers Incompleted");
        if (isCompleteBody(accountMovementRequest)) return getError(400, "Body incomplete");

        logger.debug("Request headers: " + httpHeaders.getRequestHeaders());

        return iServiceMovementAccount.getAccountDetailsMovements(accountMovementRequest, httpHeaders)
                .onItem().transform(accountMovementResponse -> {
                    ResponseHeaderDto headerDto = new ResponseHeaderDto(200, "Success");
                    return new ResponseDto(headerDto, accountMovementResponse);
                })
                .onFailure()
                .recoverWithItem(() -> {
                    ResponseHeaderDto headerDto = new ResponseHeaderDto(500, "Internal Server Error");
                    return new ResponseDto(headerDto, null);
                });
    }

    private boolean isCompleteBody(AccountMovementRequest accountsRequest) {
        logger.debug("Validating body request");

        return accountsRequest.cantidad() == null ||
                accountsRequest.direccion() == null ||
                accountsRequest.fachaFinal() == null ||
                accountsRequest.fechaInicial() == null ||
                accountsRequest.producto() == null ||
                accountsRequest.record() == null ||
                accountsRequest.tipo() == null ||
                accountsRequest.direccion().isEmpty() ||
                accountsRequest.direccion().isBlank() ||
                accountsRequest.producto().isEmpty() ||
                accountsRequest.producto().isBlank() ||
                accountsRequest.tipo().isEmpty() ||
                accountsRequest.tipo().isBlank();
    }

    private Uni<ResponseDto> getError(int responseCode, String message) {
        return Uni.createFrom().item(
                () -> new ResponseDto(
                        new ResponseHeaderDto(responseCode, message), null)
        );
    }

    private boolean isCompleteHeaders(HttpHeaders headers) {
        logger.debug("Validating http headers date");
        // Verificar la presencia de los headers requeridos
        return (headers.getRequestHeaders().containsKey("date") ||
                headers.getRequestHeaders().containsKey("channel") &&
                        headers.getRequestHeaders().containsKey("terminal") &&
                        headers.getRequestHeaders().containsKey("user") &&
                        headers.getRequestHeaders().containsKey("operationName"));
    }
}
