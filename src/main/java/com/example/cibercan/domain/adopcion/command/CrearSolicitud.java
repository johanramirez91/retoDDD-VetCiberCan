package com.example.cibercan.domain.adopcion.command;

import co.com.sofka.domain.generic.Command;
import com.example.cibercan.domain.adopcion.value.AdopcionId;
import com.example.cibercan.domain.adopcion.value.Estado;
import com.example.cibercan.genericvalues.Fecha;


import java.util.Objects;

public class CrearSolicitud extends Command {

    private final AdopcionId adopcionId;
    private final Estado estado;
    private final Fecha fecha;

    public CrearSolicitud(AdopcionId adopcionId, Estado estado, Fecha fecha) {
        this.adopcionId = adopcionId;
        this.estado = estado;
        this.fecha = fecha;
    }

    public AdopcionId getAdopcionId() {
        return adopcionId;
    }

    public Estado getEstado() {
        return estado;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
