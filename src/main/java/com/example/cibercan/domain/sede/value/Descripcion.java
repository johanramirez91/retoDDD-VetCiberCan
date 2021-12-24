package com.example.cibercan.domain.sede.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {

    private final String descripcion;

    public Descripcion(String descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion, "La descripción no puede ser nula");
        if (descripcion.isBlank()){
            throw new IllegalArgumentException("La descripción no puede estar vacia");
        }

        if (descripcion.length() < 8){
            throw new IllegalArgumentException("La descripción debe tener al menos 8 caracteres");
        }
    }


    @Override
    public String value() {
        return descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descripcion that = (Descripcion) o;
        return Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion);
    }
}
