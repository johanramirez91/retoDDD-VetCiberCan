package com.example.cibercan.genericvalues;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<String> {

    private final String email;

    public Email(String email) {
        this.email = Objects.requireNonNull(email);
        if (this.email.isBlank()){
            throw new IllegalArgumentException("El email no puede estar vacio");
        }

        if (!this.email.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")){
            throw new IllegalArgumentException("El email no es valido");
        }
    }

    @Override
    public String value() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
