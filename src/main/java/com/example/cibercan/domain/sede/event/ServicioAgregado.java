package com.example.cibercan.domain.sede.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.genericvalues.Descripcion;
import com.example.cibercan.domain.sede.value.ServicioId;

public class ServicioAgregado extends DomainEvent {

    private final ServicioId servicioId;
    private final Descripcion descripcion;

    public ServicioAgregado(ServicioId servicioId, Descripcion descripcion) {
        super("sofka.sede.servicioagregado");
        this.servicioId = servicioId;
        this.descripcion = descripcion;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
