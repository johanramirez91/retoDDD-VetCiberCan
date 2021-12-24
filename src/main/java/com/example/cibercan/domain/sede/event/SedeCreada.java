package com.example.cibercan.domain.sede.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.sede.value.Direccion;
import com.example.cibercan.genericvalues.Nombre;
import com.example.cibercan.genericvalues.Telefono;

public class SedeCreada extends DomainEvent {

    private final Nombre nombre;
    private final Telefono telefono;
    private final Direccion direccion;

    public SedeCreada(Nombre nombre, Telefono telefono, Direccion direccion) {
        super("sofka.sede.sedecreada");
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
