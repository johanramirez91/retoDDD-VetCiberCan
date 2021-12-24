package com.example.cibercan.domain.tienda.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.genericvalues.Nombre;

public class TiendaCreada extends DomainEvent {

    private final Nombre nombre;

    public TiendaCreada(Nombre nombre) {
        super("sofka.tienda.tiendacreada");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
