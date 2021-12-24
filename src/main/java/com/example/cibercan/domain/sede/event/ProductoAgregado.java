package com.example.cibercan.domain.sede.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.sede.value.Cantidad;
import com.example.cibercan.domain.sede.value.Precio;
import com.example.cibercan.domain.sede.value.ProductoId;
import com.example.cibercan.genericvalues.Nombre;

public class ProductoAgregado extends DomainEvent {

    private final ProductoId productoId;
    private final Nombre nombre;
    private final Cantidad cantidad;
    private final Precio precio;

    public ProductoAgregado(ProductoId productoId, Nombre nombre, Cantidad cantidad, Precio precio) {
        super("sofka.sede.productoagregado");
        this.productoId = productoId;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }

    public Precio getPrecio() {
        return precio;
    }
}
