package com.banreservas.account.movement.services.impl;

import com.banreservas.account.movement.dtos.AccountMovementRequest;
import com.banreservas.account.movement.dtos.AccountMovementResponse;
import com.banreservas.account.movement.services.IServiceMovementAccount;
import com.banreservas.account.movement.utils.ConsultaMovimientoMapper;
import com.brrd.service.services.ConsultaMovimientosRequest;
import com.brrd.service.services.IconsultaMovimientosRequest;
import io.quarkiverse.cxf.annotation.CXFClient;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;


@ApplicationScoped
public class ServiceMovementAccountImpl implements IServiceMovementAccount {

    Logger logger = LoggerFactory.getLogger(ServiceMovementAccountImpl.class);

    @CXFClient("consultaMovimientos")
    IconsultaMovimientosRequest iconsultaMovimientosRequest;

    @Override
    public Uni<AccountMovementResponse> getAccountDetailsMovements(AccountMovementRequest accountMovementRequest, HttpHeaders httpHeaders) {
        ConsultaMovimientosRequest request = ConsultaMovimientoMapper.mapDtoToSoap(accountMovementRequest);

        logger.info("getting movement resume from user: ");

        return Uni.createFrom().item(() -> {
                    try {
                        // Invocacion el servicio SOAP
                        return iconsultaMovimientosRequest.consultaMovimientos(request);
                    } catch (Exception e) {
                        // Manejo de excepcion
                        logger.error("Error invoking SOAP service", e);
                        throw e;
                    }
                }).map(response -> {
                    try {
                        // Mapeo respuesta SOAP a DTO
                        return ConsultaMovimientoMapper.mapSoapToDto(response);
                    } catch (Exception e) {
                        // Manejo de excepcion durante el mapeo
                        logger.error("Error mapping SOAP response to DTO", e);
                        throw new RuntimeException("Error mapping SOAP response to DTO", e);
                    }
                })
                // Devuelve un DTO vacío en caso de fallo
                .onFailure().recoverWithItem(this.empty());
    }
    public static AccountMovementResponse empty() {
        return new AccountMovementResponse(Collections.emptyList());
    }
}
