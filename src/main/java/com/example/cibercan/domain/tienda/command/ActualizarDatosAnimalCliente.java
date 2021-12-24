package com.example.cibercan.domain.tienda.command;

import co.com.sofka.domain.generic.Command;
import com.example.cibercan.domain.tienda.value.*;
import com.example.cibercan.genericvalues.Nombre;

public class ActualizarDatosAnimalCliente extends Command {

    private final TiendaId tiendaId;
    private final AnimalClienteId animalClienteId;
    private final Nombre nombre;
    private final EdadAnimalCliente edadAnimalCliente;
    private final PesoAnimal pesoAnimal;
    private final Raza raza;

    public ActualizarDatosAnimalCliente(TiendaId tiendaId, AnimalClienteId animalClienteId, Nombre nombre, EdadAnimalCliente edadAnimalCliente, PesoAnimal pesoAnimal, Raza raza) {
        this.tiendaId = tiendaId;
        this.animalClienteId = animalClienteId;
        this.nombre = nombre;
        this.edadAnimalCliente = edadAnimalCliente;
        this.pesoAnimal = pesoAnimal;
        this.raza = raza;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
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
