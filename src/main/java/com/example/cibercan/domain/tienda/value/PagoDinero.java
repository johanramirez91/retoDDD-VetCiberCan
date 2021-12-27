package com.example.cibercan.domain.tienda.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PagoDinero implements ValueObject<Double> {

    private final Double pagoDinero;

    public PagoDinero(Double pagoDinero) {
        this.pagoDinero = Objects.requireNonNull(pagoDinero, "El pago no puede ser nulo");

        if (pagoDinero < 1) {
            throw new IllegalArgumentException("El pago debe ser mayo que 0");
        }
    }

    @Override
    public Double value() {
        return pagoDinero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagoDinero that = (PagoDinero) o;
        return Objects.equals(pagoDinero, that.pagoDinero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagoDinero);
    }
}
