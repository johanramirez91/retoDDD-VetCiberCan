package com.example.cibercan.domain.sede.command;

import co.com.sofka.domain.generic.Command;
import com.example.cibercan.domain.sede.value.Descripcion;
import com.example.cibercan.domain.sede.value.SedeId;
import com.example.cibercan.domain.sede.value.ServicioId;

public class AgregarServicio extends Command {

    private final SedeId sedeId;
    private final ServicioId servicioId;
    private final Descripcion descripcion;

    public AgregarServicio(SedeId sedeId, ServicioId servicioId, Descripcion descripcion) {
        this.sedeId = sedeId;
        this.servicioId = servicioId;
        this.descripcion = descripcion;
    }

    public SedeId getSedeId() {
        return sedeId;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
