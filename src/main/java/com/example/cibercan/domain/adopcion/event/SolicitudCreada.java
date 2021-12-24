package com.example.cibercan.domain.adopcion.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.adopcion.value.Estado;
import com.example.cibercan.domain.adopcion.value.SolicitudId;
import com.example.cibercan.genericvalues.Fecha;

public class SolicitudCreada extends DomainEvent {

    private final SolicitudId solicitudId;
    private final Estado estado;
    private final Fecha fecha;

    public SolicitudCreada(SolicitudId solicitudId, Estado estado, Fecha fecha) {
        super("sofka.adopcion.solicitudcreada");
        this.solicitudId = solicitudId;
        this.estado = estado;
        this.fecha = fecha;
    }

    public SolicitudId getSolicitudId() {
        return solicitudId;
    }

    public Estado getEstado() {
        return estado;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
