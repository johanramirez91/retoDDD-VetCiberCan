package com.example.cibercan.domain.sede;

import co.com.sofka.domain.generic.Entity;
import com.example.cibercan.genericvalues.Descripcion;
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

    public Descripcion getDescripcion() {
        return descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Servicio servicio = (Servicio) o;
        return Objects.equals(descripcion, servicio.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), descripcion);
    }
}
