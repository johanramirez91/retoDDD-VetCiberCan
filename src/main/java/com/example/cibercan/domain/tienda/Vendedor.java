package com.example.cibercan.domain.tienda;

import co.com.sofka.domain.generic.Entity;
import com.example.cibercan.domain.tienda.value.FechaPago;
import com.example.cibercan.domain.tienda.value.VendedorId;
import com.example.cibercan.genericvalues.Email;
import com.example.cibercan.genericvalues.Nombre;
import com.example.cibercan.genericvalues.Telefono;

import java.util.Objects;

public class Vendedor extends Entity<VendedorId> {

    private Email email;
    private Telefono telefono;
    private Nombre nombre;
    private FechaPago fechaPago;

    public Vendedor(VendedorId vendedorId, Email email, Telefono telefono, Nombre nombre, FechaPago fechaPago) {
        super(vendedorId);
        this.email = Objects.requireNonNull(email, "El email no puede ser nulo");
        this.telefono = Objects.requireNonNull(telefono, "El telefono no puede ser nulo");
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.fechaPago = Objects.requireNonNull(fechaPago, "La fecha no puede ser nulo");
    }

    public void actualizarDatosVendedor(Nombre nombre, Email email, Telefono telefono, FechaPago fechaPago) {
        this.email = Objects.requireNonNull(email, "El email no puede ser nulo");
        this.telefono = Objects.requireNonNull(telefono, "El telefono no puede ser nulo");
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.fechaPago = Objects.requireNonNull(fechaPago, "La fecha no puede ser nulo");
    }

    public Email getEmail() {
        return email;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public FechaPago getFechaPago() {
        return fechaPago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vendedor vendedor = (Vendedor) o;
        return Objects.equals(email, vendedor.email) && Objects.equals(telefono, vendedor.telefono) && Objects.equals(nombre, vendedor.nombre) && Objects.equals(fechaPago, vendedor.fechaPago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, telefono, nombre, fechaPago);
    }
}
