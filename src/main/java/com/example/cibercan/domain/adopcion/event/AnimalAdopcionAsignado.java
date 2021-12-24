package com.example.cibercan.domain.adopcion.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.adopcion.value.AnimalAdopcionId;
import com.example.cibercan.domain.adopcion.value.Diagnostico;
import com.example.cibercan.genericvalues.Descripcion;
import com.example.cibercan.genericvalues.Nombre;

public class AnimalAdopcionAsignado extends DomainEvent {

    private final AnimalAdopcionId animalAdopcionId;
    private final Nombre nombre;
    private final Diagnostico diagnostico;
    private final Descripcion descripcion;

    public AnimalAdopcionAsignado(AnimalAdopcionId animalAdopcionId, Nombre nombre, Diagnostico diagnostico, Descripcion descripcion) {
        super("sofka.adopcion.animaladopcionasignado");
        this.animalAdopcionId = animalAdopcionId;
        this.nombre = nombre;
        this.diagnostico = diagnostico;
        this.descripcion = descripcion;
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
