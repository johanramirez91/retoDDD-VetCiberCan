package com.example.cibercan.domain.adopcion;

import co.com.sofka.domain.generic.Entity;
import com.example.cibercan.domain.adopcion.value.AnimalAdopcionId;
import com.example.cibercan.domain.adopcion.value.Diagnostico;
import com.example.cibercan.genericvalues.Descripcion;
import com.example.cibercan.genericvalues.Nombre;

import java.util.Objects;

public class AnimalAdopcion extends Entity<AnimalAdopcionId> {

    private Nombre nombre;
    private Diagnostico diagnostico;
    private Descripcion descripcion;

    public AnimalAdopcion(AnimalAdopcionId animalAdopcionId, Nombre nombre, Diagnostico diagnostico, Descripcion descripcion) {
        super(animalAdopcionId);
        this.nombre = nombre;
        this.diagnostico = diagnostico;
        this.descripcion = descripcion;
    }

    public void actualizarNombreAnimalAdopcion(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulu");
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion, "La descipcion no puede ser nula");
    }

    public void actualizarDiagnostico(Diagnostico diagnostico){
        this.diagnostico = Objects.requireNonNull(diagnostico,"El diagnostico no puede ser nulo");
    }

    public Nombre Nombre() {
        return nombre;
    }

    public Diagnostico Diagnostico() {
        return diagnostico;
    }

    public Descripcion Descripcion() {
        return descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AnimalAdopcion that = (AnimalAdopcion) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(diagnostico, that.diagnostico) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nombre, diagnostico, descripcion);
    }
}
