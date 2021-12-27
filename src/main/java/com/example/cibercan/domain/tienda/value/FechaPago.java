package com.example.cibercan.domain.tienda.value;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Pattern;

public class FechaPago implements ValueObject<String> {

    private final String fecha;
    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$");


    public FechaPago(int dia, int mes, int anio) {
        var fechaPago = LocalDate.of(Objects.requireNonNull(anio), Objects.requireNonNull(mes), Objects.requireNonNull(dia));
        if (fechaPago.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("La fecha de pago no puede ser del pasado");
        }

        this.fecha = fechaPago.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        if (!DATE_PATTERN.matcher(this.fecha).matches()){
            throw new IllegalArgumentException("La fecha no esta en el formato valido dd-mm-yyyy");
        }
    }

    @Override
    public String value() {
        return fecha;
    }

}
