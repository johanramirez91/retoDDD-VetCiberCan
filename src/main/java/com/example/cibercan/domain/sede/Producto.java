package com.example.cibercan.domain.sede;

import co.com.sofka.domain.generic.Entity;
import com.example.cibercan.domain.sede.value.Cantidad;
import com.example.cibercan.domain.sede.value.Precio;
import com.example.cibercan.domain.sede.value.ProductoId;
import com.example.cibercan.genericvalues.Nombre;

import java.util.Objects;

public class Producto extends Entity<ProductoId> {

    private Nombre nombre;
    private Precio precio;
    private Cantidad cantidad;

    public Producto(ProductoId productoId, Nombre nombre, Precio precio, Cantidad cantidad) {
        super(productoId);
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public void actualizarDatosProducto(Nombre nombre, Precio precio, Cantidad cantidad){
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.precio = Objects.requireNonNull(precio, "El precio no puede ser nulo");
        this.cantidad = Objects.requireNonNull(cantidad, "La cantidad no puede ser nulo");
    }

    public Nombre Nombre() {
        return nombre;
    }

    public Precio Precio() {
        return precio;
    }

    public Cantidad Cantidad() {
        return cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Producto producto = (Producto) o;
        return Objects.equals(nombre, producto.nombre) && Objects.equals(precio, producto.precio) && Objects.equals(cantidad, producto.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nombre, precio, cantidad);
    }
}
