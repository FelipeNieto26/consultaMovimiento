package com.banreservas.account.movement.dtos;

import com.brrd.service.services.TipoProductoNum;
import io.smallrye.common.constraint.NotNull;

import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;

public record AccountMovementRequest(
        @NotNull Integer cantidad,
        @NotNull String direccion,
        @NotNull XMLGregorianCalendar fachaFinal,
        @NotNull XMLGregorianCalendar fechaInicial,
        @NotNull Double montoFinal,
        @NotNull Double montoInicial,
        @NotNull String producto,
        @NotNull Integer record,
        @NotNull String tipo,
        @NotNull TipoProductoNum tipoProducto
) implements Serializable {}
