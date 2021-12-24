package com.example.cibercan.domain.tienda.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descuento implements ValueObject<Double> {

    private final Double descuento;

    public Descuento(Double descuento) {
        this.descuento = Objects.requireNonNull(descuento);
        if (descuento < 1){
            throw new IllegalArgumentException("El descuento debe ser mayo a 1");
        }

        if (descuento.isInfinite()){
            throw new IllegalArgumentException("El descuento debe ser un valor valido");
        }
    }

    @Override
    public Double value() {
        return descuento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descuento descuento1 = (Descuento) o;
        return Objects.equals(descuento, descuento1.descuento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descuento);
    }
}
