package com.example.cibercan.domain.tienda;

import co.com.sofka.domain.generic.Entity;
import com.example.cibercan.domain.tienda.value.AnimalClienteId;
import com.example.cibercan.domain.tienda.value.EdadAnimalCliente;
import com.example.cibercan.domain.tienda.value.PesoAnimal;
import com.example.cibercan.domain.tienda.value.Raza;
import com.example.cibercan.genericvalues.Nombre;

import java.util.Objects;

public class AnimalCliente extends Entity<AnimalClienteId> {


    private Nombre nombre;
    private EdadAnimalCliente edadAnimalCliente;
    private PesoAnimal pesoAnimal;
    private Raza raza;

    public AnimalCliente(AnimalClienteId animalClienteId, Nombre nombre, EdadAnimalCliente edadAnimalCliente, PesoAnimal pesoAnimal, Raza raza) {
        super(animalClienteId);
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.edadAnimalCliente = Objects.requireNonNull(edadAnimalCliente, "La edad no puede ser nulo");
        this.pesoAnimal = Objects.requireNonNull(pesoAnimal, "El peso no puede ser nulo");
        this.raza = Objects.requireNonNull(raza, "La raza no puede ser nulo");
    }

    public void actualizarDatosAnimalCliente(Nombre nombre, EdadAnimalCliente edadAnimalCliente, PesoAnimal pesoAnimal, Raza raza){
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.edadAnimalCliente = Objects.requireNonNull(edadAnimalCliente, "La edad no puede ser nulo");
        this.pesoAnimal = Objects.requireNonNull(pesoAnimal, "El peso no puede ser nulo");
        this.raza = Objects.requireNonNull(raza, "La raza no puede ser nulo");
    }

    public Nombre getNombre() {
        return nombre;
    }

    public EdadAnimalCliente getEdadAnimalCliente() {
        return edadAnimalCliente;
    }

    public PesoAnimal getPesoAnimal() {
        return pesoAnimal;
    }

    public Raza getRaza() {
        return raza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AnimalCliente that = (AnimalCliente) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(edadAnimalCliente, that.edadAnimalCliente) && Objects.equals(pesoAnimal, that.pesoAnimal) && Objects.equals(raza, that.raza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nombre, edadAnimalCliente, pesoAnimal, raza);
    }
}
