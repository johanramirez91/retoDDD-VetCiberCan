package com.example.cibercan.domain.tienda;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.tienda.event.*;
import com.example.cibercan.domain.tienda.value.*;
import com.example.cibercan.genericvalues.Email;
import com.example.cibercan.genericvalues.Nombre;
import com.example.cibercan.genericvalues.Telefono;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Tienda extends AggregateEvent<TiendaId> {

    protected Nombre nombre;
    protected Set<Cliente> clientes;
    protected Set<AnimalCliente> animales;
    protected Set<Vendedor> vendedores;

    private Tienda(TiendaId tiendaId){
        super(tiendaId);
        subscribe(new TiendaChange(this));
    }

    public static Tienda from(TiendaId tiendaId, List<DomainEvent> events){
        var tienda = new Tienda(tiendaId);
        events.forEach(tienda::applyEvent);
        return tienda;
    }

    public Tienda(TiendaId tiendaId, Nombre nombre) {
        super(tiendaId);
        appendChange(new TiendaCreada(nombre));
    }

    public void asignarCliente(ClienteId clienteId, Nombre nombre, Email email, Telefono telefono, PagoDinero pagoDinero, Descuento descuento){
        Objects.requireNonNull(clienteId, "El id no puede ser nulo");
        Objects.requireNonNull(email, "El email no pude ser nulo");
        Objects.requireNonNull(telefono, "El telefono no puede ser nulo");
        Objects.requireNonNull(pagoDinero, "El pago no puede ser nulo");
        Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        appendChange(new ClienteAsignado(clienteId, nombre, email, telefono, pagoDinero, descuento)).apply();
    }

    public void actualizarDatosCliente(ClienteId clienteId, Nombre nombre, Email email, Telefono telefono, PagoDinero pagoDinero, Descuento descuento){
        appendChange(new DatosClienteActualizados(clienteId, nombre, pagoDinero, email, telefono, descuento)).apply();
    }

    public void asignarVendedor(VendedorId vendedorId, Nombre nombre, Telefono telefono, Email email, FechaPago fechaPago){
        Objects.requireNonNull(vendedorId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        Objects.requireNonNull(email);
        appendChange(new VendedorAsignado(vendedorId, email, telefono, nombre, fechaPago)).apply();
    }

    public void asignarDescuento(ClienteId clienteId, Descuento descuento){
        Objects.requireNonNull(clienteId, "El id no puede ser nulo");
        Objects.requireNonNull(descuento, "El descuento no puede ser nulo");
        appendChange(new DescuentoAsignado(clienteId, descuento));
    }

    public void actualizarDatosVendedor(VendedorId vendedorId, Email email, Telefono telefono, Nombre nombre, FechaPago fechaPago){
        appendChange(new DatosVendedorActualizados(vendedorId, email, telefono, nombre, fechaPago)).apply();
    }

    public void asignarAnimalCliente(AnimalClienteId animalClienteId, Nombre nombre, PesoAnimal pesoAnimal, Raza raza, EdadAnimalCliente edadAnimalCliente){
        Objects.requireNonNull(animalClienteId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(pesoAnimal);
        Objects.requireNonNull(raza);
        Objects.requireNonNull(edadAnimalCliente);
        appendChange(new AnimalClienteAsignado(animalClienteId, nombre, edadAnimalCliente, pesoAnimal, raza)).apply();
    }

    public void actualizarDatosAnimalCliente(AnimalClienteId animalClienteId, Nombre nombre, PesoAnimal pesoAnimal, Raza raza, EdadAnimalCliente edadAnimalCliente){
        appendChange(new DatosAnimalClienteActualizados(animalClienteId, nombre, edadAnimalCliente, pesoAnimal, raza)).apply();
    }

    //Querys para validaciones
    public Optional<Cliente> obtenerClientesPorId(ClienteId clienteId){
        return Clientes().stream()
                .filter(cliente -> cliente.identity().equals(clienteId))
                .findFirst();
    }

    public Optional<AnimalCliente> obtenerAnimalesPorId(AnimalClienteId animalClienteId){
        return Animales().stream()
                .filter(animal -> animal.identity().equals(animalClienteId))
                .findFirst();
    }

    public Optional<Vendedor> obtenerVendedorePorId(VendedorId vendedorId){
        return Vendedores().stream()
                .filter(vendedor -> vendedor.identity().equals(vendedorId))
                .findFirst();
    }


    public Nombre Nombre() {
        return nombre;
    }

    public Set<Cliente> Clientes() {
        return clientes;
    }

    public Set<AnimalCliente> Animales() {
        return animales;
    }

    public Set<Vendedor> Vendedores() {
        return vendedores;
    }
}
