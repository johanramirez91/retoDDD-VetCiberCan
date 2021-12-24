package com.example.cibercan.domain.sede;

import co.com.sofka.domain.generic.Entity;
import com.example.cibercan.domain.sede.value.Descripcion;
import com.example.cibercan.domain.sede.value.ServicioId;

import java.util.Objects;

public class Servicio extends Entity<ServicioId> {

    private Descripcion descripcion;

    public Servicio(ServicioId servicioId, Descripcion descripcion) {
        super(servicioId);
        this.descripcion = descripcion;
    }

    public void actualizarDatosServicio(ServicioId servicioId, Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion, "La descripción no puede ser nula");
    }

    public Descripcion Descripcion() {
        return descripcion;
    }
}
