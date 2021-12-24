package com.example.cibercan.domain.sede.command;

import co.com.sofka.domain.generic.Command;
import com.example.cibercan.domain.sede.value.Direccion;
import com.example.cibercan.domain.sede.value.SedeId;
import com.example.cibercan.genericvalues.Nombre;
import com.example.cibercan.genericvalues.Telefono;

public class CrearSede extends Command {

    private final SedeId sedeId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Direccion direccion;

    public CrearSede(SedeId sedeId, Nombre nombre, Telefono telefono, Direccion direccion) {
        this.sedeId = sedeId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public SedeId getSedeId() {
        return sedeId;
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
