package com.example.cibercan.domain.tienda.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.tienda.value.AnimalClienteId;
import com.example.cibercan.domain.tienda.value.EdadAnimalCliente;
import com.example.cibercan.domain.tienda.value.PesoAnimal;
import com.example.cibercan.domain.tienda.value.Raza;
import com.example.cibercan.genericvalues.Nombre;

public class AnimalClienteAsignado extends DomainEvent {

    private final AnimalClienteId animalClienteId;
    private final Nombre nombre;
    private final EdadAnimalCliente edadAnimalCliente;
    private final PesoAnimal pesoAnimal;
    private final Raza raza;

    public AnimalClienteAsignado(AnimalClienteId animalClienteId, Nombre nombre, EdadAnimalCliente edadAnimalCliente, PesoAnimal pesoAnimal, Raza raza) {
        super("sofka.tienda.animalclienteasignado");
        this.animalClienteId = animalClienteId;
        this.nombre = nombre;
        this.edadAnimalCliente = edadAnimalCliente;
        this.pesoAnimal = pesoAnimal;
        this.raza = raza;
    }

    public AnimalClienteId getAnimalClienteId() {
        return animalClienteId;
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
}
