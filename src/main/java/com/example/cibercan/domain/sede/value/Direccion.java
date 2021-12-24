package com.example.cibercan.domain.sede.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Direccion implements ValueObject<String> {

    private final String direccion;

    public Direccion(String direccion) {
        this.direccion = Objects.requireNonNull(direccion);
        if (direccion.length() < 9){
            throw new IllegalArgumentException("La dirección debe contener al menos 9 caracteres");
        }

        if (!direccion.matches("[\\\\w-]+.*[^\\\\d]$")){
            throw new IllegalArgumentException("Dirección no valida");
        }
    }

    @Override
    public String value() {
        return direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direccion direccion1 = (Direccion) o;
        return Objects.equals(direccion, direccion1.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direccion);
    }

}
