package com.example.cibercan.domain.adopcion.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DocumentoContrato implements ValueObject<String> {

    private final String documentoContrato;

    public DocumentoContrato(String documentoContrato) {
        this.documentoContrato = Objects.requireNonNull(documentoContrato, "El documento no puede ser nulo");

        if (documentoContrato.isBlank()) {
            throw new IllegalArgumentException("El documento no puede estar vacio");
        }

        if (documentoContrato.length() < 50){
            throw new IllegalArgumentException("El documento debe contener al menos 50 caracteres");
        }
    }


    @Override
    public String value() {
        return documentoContrato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentoContrato that = (DocumentoContrato) o;
        return Objects.equals(documentoContrato, that.documentoContrato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentoContrato);
    }
}
