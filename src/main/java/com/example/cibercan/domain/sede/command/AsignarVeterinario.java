package com.example.cibercan.domain.sede.command;

import co.com.sofka.domain.generic.Command;
import com.example.cibercan.domain.sede.value.SedeId;
import com.example.cibercan.domain.sede.value.VeterinarioId;
import com.example.cibercan.genericvalues.Email;
import com.example.cibercan.genericvalues.Nombre;
import com.example.cibercan.genericvalues.Telefono;

public class AsignarVeterinario extends Command {

    private final SedeId sedeId;
    private final VeterinarioId veterinarioId;
    private final Nombre nombre;
    private final Email email;
    private final Telefono telefono;

    public AsignarVeterinario(SedeId sedeId, VeterinarioId veterinarioId, Nombre nombre, Email email, Telefono telefono) {
        this.sedeId = sedeId;
        this.veterinarioId = veterinarioId;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public SedeId getSedeId() {
        return sedeId;
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
