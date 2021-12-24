package com.example.cibercan.domain.tienda.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Raza implements ValueObject<String> {

    private final String raza;

    public Raza(String raza) {
        this.raza = Objects.requireNonNull(raza, "La raza no puede ser nula");

        if (raza.isBlank()){
            throw new IllegalArgumentException("La raza no puede estar vacia");
        }

        if (raza.length() < 5){
            throw new IllegalArgumentException("Se debe asignar una raza valida");
        }
    }


    @Override
    public String value() {
        return raza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Raza raza1 = (Raza) o;
        return Objects.equals(raza, raza1.raza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raza);
    }
}
