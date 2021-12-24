package com.example.cibercan.domain.adopcion.command;

import co.com.sofka.domain.generic.Command;
import com.example.cibercan.domain.adopcion.value.AdopcionId;
import com.example.cibercan.domain.adopcion.value.Estado;
import com.example.cibercan.domain.adopcion.value.SolicitudId;

public class ActualizarSolicitud extends Command {

    private final AdopcionId adopcionId;
    private final SolicitudId solicitudId;
    private final Estado estado;

    public ActualizarSolicitud(AdopcionId adopcionId, SolicitudId solicitudId, Estado estado) {
        this.adopcionId = adopcionId;
        this.solicitudId = solicitudId;
        this.estado = estado;
    }

    public AdopcionId getAdopcionId() {
        return adopcionId;
    }

    public Estado getEstado() {
        return estado;
    }

    public SolicitudId getSolicitudId() {
        return solicitudId;
    }
}
