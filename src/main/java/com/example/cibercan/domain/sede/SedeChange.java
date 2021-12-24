package com.example.cibercan.domain.sede;

import co.com.sofka.domain.generic.EventChange;
import com.example.cibercan.domain.sede.event.*;

import java.util.HashSet;

public class SedeChange extends EventChange {

    public SedeChange(Sede sede) {
        apply((SedeCreada event) -> {
            sede.nombre = event.getNombre();
            sede.direccion = event.getDireccion();
            sede.telefono = event.getTelefono();
            sede.productos = new HashSet<>();
            sede.servicios = new HashSet<>();
            sede.veterinarios = new HashSet<>();
        });

        apply((DatosProductoActualizados event) -> {
            var producto = sede.obtenerProductosPorId(event.getProductoId())
                    .orElseThrow(() -> new IllegalArgumentException("No existe producto con Id: " + event.getProductoId()));
            producto.actualizarDatosProducto(event.getNombre(), event.getPrecio(), event.getCantidad());
        });

        apply((DatosServicioActualizados event) -> {
            var servicio = sede.obtenerServiciosPorId(event.getServicioId())
                    .orElseThrow(() -> new IllegalArgumentException("No existe servicio con Id: " + event.getServicioId()));
            servicio.actualizarDatosServicio(event.getServicioId(), event.getDescripcion());
        });

        apply((ProductoAgregado event) ->
                sede.productos.add(new Producto(event.getProductoId(), event.getNombre(), event.getPrecio(), event.getCantidad())));

        apply((ServicioAgregado event) ->
                sede.servicios.add(new Servicio(event.getServicioId(), event.getDescripcion())));

        apply((TiendaAsignada event) ->
                sede.tiendaId = event.getTiendaId());

        apply((VeterinarioAsignado event) ->
                sede.veterinarios.add(new Veterinario(event.getVeterinarioId(), event.getNombre(), event.getEmail(), event.getTelefono())));

    }
}
