package com.example.cibercan.domain.tienda.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EdadAnimalCliente implements ValueObject<Integer> {

    private final Integer edadAnimalCliente;

    public EdadAnimalCliente(Integer edadAnimalCliente) {
        this.edadAnimalCliente = Objects.requireNonNull(edadAnimalCliente, "La edad no puede estar vacia");

        if (edadAnimalCliente < 1){
            throw new IllegalArgumentException("La edad debe ser mayor que 0");
        }

        if (edadAnimalCliente > 25){
            throw new IllegalArgumentException("No es posible que el animal tenga mas de 25 años");
        }
    }


    @Override
    public Integer value() {
        return edadAnimalCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EdadAnimalCliente that = (EdadAnimalCliente) o;
        return Objects.equals(edadAnimalCliente, that.edadAnimalCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(edadAnimalCliente);
    }
}
