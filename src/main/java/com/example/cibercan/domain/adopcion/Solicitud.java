package com.example.cibercan.domain.adopcion;

import co.com.sofka.domain.generic.Entity;
import com.example.cibercan.domain.adopcion.value.Estado;
import com.example.cibercan.domain.adopcion.value.SolicitudId;
import com.example.cibercan.genericvalues.Fecha;

import java.util.Objects;

public class Solicitud extends Entity<SolicitudId> {

    private Fecha fecha;
    private Estado estado;

    public Solicitud(SolicitudId entityId, Fecha fecha, Estado estado) {
        super(entityId);
        this.fecha = Objects.requireNonNull(fecha, "La fecha no puede ser nula");
        this.estado = Objects.requireNonNull(estado, "El estado no puede ser nulo");
    }

    public void actualizarSolicitud(Estado estado){
        this.estado = Objects.requireNonNull(estado, "El estado no puede ser nulo");
    }

    public Fecha Fecha() {
        return fecha;
    }

    public Estado Estado() {
        return estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Solicitud solicitud = (Solicitud) o;
        return Objects.equals(fecha, solicitud.fecha) && Objects.equals(estado, solicitud.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fecha, estado);
    }
}
