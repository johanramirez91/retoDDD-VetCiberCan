package com.example.cibercan.domain.tienda.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PesoAnimal implements ValueObject<Float> {

    private final Float pesoAnimal;

    public PesoAnimal(Float pesoAnimal) {
        this.pesoAnimal = Objects.requireNonNull(pesoAnimal, "El peso no puede estar vacio");

        if (pesoAnimal < 1){
            throw new IllegalArgumentException("El peso del animal debe ser mayor que 0");
        }

        if (pesoAnimal.isInfinite()){
            throw new IllegalArgumentException("Seguramente es hora de cambiar la bascula");
        }

        if (pesoAnimal.isNaN()){
            throw new IllegalArgumentException("El peso del animal debe ser un numero");
        }
    }

    @Override
    public Float value() {
        return pesoAnimal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PesoAnimal that = (PesoAnimal) o;
        return Objects.equals(pesoAnimal, that.pesoAnimal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesoAnimal);
    }

}
