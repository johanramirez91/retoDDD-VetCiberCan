package com.example.cibercan.genericvalues;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {

    private final String nombre;

    public Nombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
        if (this.nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }

        if (this.nombre.length() < 3) {
            throw new IllegalArgumentException("El nombre debe tener al menos 3 letras");
        }

        if (this.nombre.length() > 30){
            throw new IllegalArgumentException("El nombre debe contener menos de 30 letras");
        }
    }

    @Override
    public String value() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nombre nombre1 = (Nombre) o;
        return Objects.equals(nombre, nombre1.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
