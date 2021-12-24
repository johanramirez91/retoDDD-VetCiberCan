package com.example.cibercan.domain.adopcion.command;

import co.com.sofka.domain.generic.Command;
import com.example.cibercan.domain.adopcion.value.AdopcionId;
import com.example.cibercan.domain.adopcion.value.AnimalAdopcionId;
import com.example.cibercan.domain.adopcion.value.Diagnostico;
import com.example.cibercan.genericvalues.Descripcion;
import com.example.cibercan.genericvalues.Nombre;

import java.util.Objects;

public class AsignarAnimalAdopcion extends Command {

    private final AdopcionId adopcionId;
    private final AnimalAdopcionId animalAdopcionId;
    private final Nombre nombre;
    private final Diagnostico diagnostico;
    private final Descripcion descripcion;

    public AsignarAnimalAdopcion(AdopcionId adopcionId, AnimalAdopcionId animalAdopcionId, Nombre nombre, Diagnostico diagnostico, Descripcion descripcion) {
        this.adopcionId = adopcionId;
        this.animalAdopcionId = animalAdopcionId;
        this.nombre = nombre;
        this.diagnostico = diagnostico;
        this.descripcion = descripcion;
    }

    public AdopcionId getAdopcionId() {
        return adopcionId;
    }

    public AnimalAdopcionId getAnimalAdopcionId() {
        return animalAdopcionId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
