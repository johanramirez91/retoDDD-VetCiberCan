package com.example.cibercan.domain.adopcion.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Diagnostico implements ValueObject<String> {

    private final String diagnostico;

    public Diagnostico(String diagnostico) {
        this.diagnostico = Objects.requireNonNull(diagnostico, "Se debe proporcionar un diagnostico");

        if (diagnostico.length() < 10){
            throw new IllegalArgumentException("El diagnostico debe contener al menos 10 caracteres");
        }

        if (diagnostico.isBlank()){
            throw new IllegalArgumentException("El diagnostico no puede estar vacio");
        }
    }


    @Override
    public String value() {
        return diagnostico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnostico that = (Diagnostico) o;
        return Objects.equals(diagnostico, that.diagnostico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diagnostico);
    }
}
