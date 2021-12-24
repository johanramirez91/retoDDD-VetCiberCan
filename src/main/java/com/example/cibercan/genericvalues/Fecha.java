package com.example.cibercan.genericvalues;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.regex.Pattern;

public class Fecha implements ValueObject<String> {

    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
    private final String fecha;

    public Fecha(String fecha) {
        this.fecha = Objects.requireNonNull(fecha);

        if (this.fecha.isBlank()){
            throw new IllegalArgumentException("La fecha no puede estar vacia");
        }

        if (!DATE_PATTERN.matcher(this.fecha).matches()){
            throw new IllegalArgumentException("La fecha no esta en el formato valido aaaa-mm-dd");
        }
    }

    @Override
    public String value() {
        return fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fecha fecha1 = (Fecha) o;
        return Objects.equals(fecha, fecha1.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha);
    }


}
