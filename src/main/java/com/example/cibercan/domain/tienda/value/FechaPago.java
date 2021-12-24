package com.example.cibercan.domain.tienda.value;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class FechaPago implements ValueObject<String> {

    private final String fecha;

    public FechaPago(String fecha, int dia, int mes, int anio) {

        var fechPago = LocalDate.of(Objects.requireNonNull(anio), Objects.requireNonNull(mes), Objects.requireNonNull(dia));
        if (fechPago.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("La fecha de pago no puede ser del pasado");
        }

        this.fecha = fechPago.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public String value() {
        return fecha;
    }

}
