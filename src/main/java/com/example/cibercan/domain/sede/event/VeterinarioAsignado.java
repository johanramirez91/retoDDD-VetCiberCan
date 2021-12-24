package com.example.cibercan.domain.sede.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.sede.value.VeterinarioId;
import com.example.cibercan.genericvalues.Email;
import com.example.cibercan.genericvalues.Nombre;
import com.example.cibercan.genericvalues.Telefono;

public class VeterinarioAsignado extends DomainEvent {

    private final VeterinarioId veterinarioId;
    private final Nombre nombre;
    private final Email email;
    private final Telefono telefono;

    public VeterinarioAsignado(VeterinarioId veterinarioId, Nombre nombre, Email email, Telefono telefono) {
        super("sofka.sede.veterinarioasignado");
        this.veterinarioId = veterinarioId;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public VeterinarioId getVeterinarioId() {
        return veterinarioId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Email getEmail() {
        return email;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
