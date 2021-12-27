package com.example.cibercan.domain.tienda;

import co.com.sofka.domain.generic.EventChange;
import com.example.cibercan.domain.tienda.event.*;

import java.util.HashSet;

public class TiendaChange extends EventChange {

    public TiendaChange(Tienda tienda) {

        apply((TiendaCreada event) -> {
            tienda.nombre = event.getNombre();
            tienda.animales = new HashSet<>();
            tienda.clientes = new HashSet<>();
            tienda.vendedores = new HashSet<>();
        });

        apply((ClienteAsignado event) ->
                tienda.clientes.add(
                        new Cliente(event.getClienteId(),
                                event.getNombre(),
                                event.getPagoDinero(),
                                event.getDescuento(),
                                event.getTelefono(),
                                event.getEmail())));

        apply((DatosClienteActualizados event) -> {
            var cliente = tienda.obtenerClientesPorId(event.getClienteId())
                    .orElseThrow(() -> new IllegalArgumentException("No existe cliente con Id: " + event.getClienteId()));
            cliente.actualizarDatosCliente(event.getClienteId(),
                    event.getNombre(),
                    event.getPagoDinero(),
                    event.getDescuento(),
                    event.getTelefono(),
                    event.getEmail());
        });

        apply((VendedorAsignado event) ->
                tienda.vendedores.add(new Vendedor(event.getVendedorId(),
                        event.getEmail(),
                        event.getTelefono(),
                        event.getNombre(),
                        event.getFechaPago())));

        apply((DatosVendedorActualizados event) -> {
            var vendedor = tienda.obtenerVendedorePorId(event.getVendedorId())
                    .orElseThrow(() -> new IllegalArgumentException("No existe vendedor con Id: " + event.getVendedorId()));
            vendedor.actualizarDatosVendedor(event.getNombre(),
                    event.getEmail(),
                    event.getTelefono(),
                    event.getFechaPago());
        });

        apply((AnimalClienteAsignado event) ->
                tienda.animales.add(new AnimalCliente(event.getAnimalClienteId(),
                        event.getNombre(),
                        event.getEdadAnimalCliente(),
                        event.getPesoAnimal(),
                        event.getRaza())));

        apply((DatosAnimalClienteActualizados event) -> {
            var animal = tienda.obtenerAnimalesPorId(event.getAnimalClienteId())
                    .orElseThrow(() ->
                            new IllegalArgumentException("No existe animal con Id: " + event.getAnimalClienteId()));
            animal.actualizarDatosAnimalCliente(event.getNombre(),
                    event.getEdadAnimalCliente(),
                    event.getPesoAnimal(),
                    event.getRaza());
        });

        apply((DescuentoAsignado event) -> {
            var cliente = tienda.obtenerClientesPorId(event.getClienteId())
                    .orElseThrow(() -> new IllegalArgumentException("No existe cliente con Id: " + event.getClienteId()));
            cliente.asignarDescuento(event.getDescuento(), event.getClienteId());
        });
    }
}
