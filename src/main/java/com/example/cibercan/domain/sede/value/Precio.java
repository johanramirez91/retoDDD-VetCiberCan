package com.example.cibercan.domain.sede.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Precio implements ValueObject<Double> {

    private final Double precio;

    public Precio(Double precio) {
        this.precio = Objects.requireNonNull(precio);
        if (precio.isInfinite()) {
            throw new IllegalArgumentException("El precio debe ser un numero aceptado");
        }

        if (precio.isNaN()) {
            throw new IllegalArgumentException("El precio debe ser un valor numérico");
        }

        if (precio < 1) {
            throw new IllegalArgumentException("El precio debe ser mayor o igual a 1");
        }
    }

    @Override
    public Double value() {
        return precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Precio precio1 = (Precio) o;
        return Objects.equals(precio, precio1.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(precio);
    }
}
