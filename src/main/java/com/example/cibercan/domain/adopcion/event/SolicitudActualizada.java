package com.example.cibercan.domain.adopcion.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.adopcion.value.Estado;
import com.example.cibercan.domain.adopcion.value.SolicitudId;

public class SolicitudActualizada extends DomainEvent {

    private final Estado.EstadoSoliciutd estadoSoliciutd;
    private final SolicitudId solicitudId;

    public SolicitudActualizada(Estado.EstadoSoliciutd estadoSoliciutd, SolicitudId solicitudId) {
        super("sofka.adopcion.solicitudactualizada");
        this.estadoSoliciutd = estadoSoliciutd;
        this.solicitudId = solicitudId;
    }

    public Estado.EstadoSoliciutd getEstadoSoliciutd() {
        return estadoSoliciutd;
    }

    public SolicitudId getSolicitudId() {
        return solicitudId;
    }
}
