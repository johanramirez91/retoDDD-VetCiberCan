package com.example.cibercan.domain.sede.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cantidad implements ValueObject<Integer> {

    private final Integer cantidad;

    public Cantidad(Integer cantidad) {
        this.cantidad = Objects.requireNonNull(cantidad, "La cantidad no puede ser nula");
        if (cantidad < 1) {
            throw new IllegalArgumentException("La cantidad debe ser mayor o igual que 1");
        }
    }


    @Override
    public Integer value() {
        return cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cantidad cantidad1 = (Cantidad) o;
        return Objects.equals(cantidad, cantidad1.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantidad);
    }
}
