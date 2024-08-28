package com.banreservas.account.movement.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

public record XmlResponseDto(
        Integer transactionNumber,
        LocalDateTime date,
        LocalDateTime actualDate,
        double amount,
        String movementType,
        String concept,
        String office,
        Integer tellerBranch,
        Integer tellerNumber,
        String descriptionOficce,
        double balance,
        double reference,
        String description1,
        String description2,
        String description3,
        String causal,
        Integer transactionCode,
        String state,
        Integer idPage,
        Integer idUnico,
        Integer quantity,
        Integer idExit) implements Serializable {
}

