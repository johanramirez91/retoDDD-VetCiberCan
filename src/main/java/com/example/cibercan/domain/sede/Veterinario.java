package com.example.cibercan.domain.sede;

import co.com.sofka.domain.generic.Entity;
import com.example.cibercan.domain.sede.value.VeterinarioId;
import com.example.cibercan.genericvalues.Email;
import com.example.cibercan.genericvalues.Nombre;
import com.example.cibercan.genericvalues.Telefono;

import java.util.Objects;

public class Veterinario extends Entity<VeterinarioId> {

    private Nombre nombre;
    private Email email;
    private Telefono telefono;

    public Veterinario(VeterinarioId vaterinarioId, Nombre nombre, Email email, Telefono telefono) {
        super(vaterinarioId);
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public void actualizarDatosVeterinario(Nombre nombre, Email email, Telefono telefono){
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.email = Objects.requireNonNull(email, "El email no puede ser nulo");
        this.telefono = Objects.requireNonNull(telefono, "El telefono no puede ser nulo");
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
