package com.banreservas.account.movement.dtos;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.io.Serializable;
import java.util.List;

@RegisterForReflection
public record AccountMovementResponse(
        List<XmlResponseDto> xmlResponses
        ) implements Serializable {
}
