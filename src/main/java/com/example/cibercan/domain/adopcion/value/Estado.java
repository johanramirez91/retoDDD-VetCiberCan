package com.example.cibercan.domain.adopcion.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Estado implements ValueObject<Estado.EstadoSoliciutd> {

    public enum EstadoSoliciutd {
        APROBADA,
        EN_ESPERA,
        RECHAZADA,
        CANCELADA,
    }

    private final EstadoSoliciutd estado;

    public Estado(EstadoSoliciutd estado) {
        this.estado = Objects.requireNonNull(estado, "El estado no puede ser nulo");
        if (!estado.values().equals(estado)){
            throw new IllegalArgumentException("Estado no valido");
        }
    }

    @Override
    public EstadoSoliciutd value() {
        return estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado1 = (Estado) o;
        return estado == estado1.estado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(estado);
    }
}
