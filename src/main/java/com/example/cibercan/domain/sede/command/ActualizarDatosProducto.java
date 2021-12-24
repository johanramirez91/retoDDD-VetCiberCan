package com.example.cibercan.domain.sede.command;

import co.com.sofka.domain.generic.Command;
import com.example.cibercan.domain.sede.value.Cantidad;
import com.example.cibercan.domain.sede.value.Precio;
import com.example.cibercan.domain.sede.value.ProductoId;
import com.example.cibercan.domain.sede.value.SedeId;

public class ActualizarDatosProducto extends Command {

    private final SedeId sedeId;
    private final ProductoId productoId;
    private final Precio precio;
    private final Cantidad cantidad;

    public ActualizarDatosProducto(SedeId sedeId, ProductoId productoId, Precio precio, Cantidad cantidad) {
        this.sedeId = sedeId;
        this.productoId = productoId;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public SedeId getSedeId() {
        return sedeId;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public Precio getPrecio() {
        return precio;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }
}
