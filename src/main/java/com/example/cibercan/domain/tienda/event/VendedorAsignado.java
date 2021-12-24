package com.example.cibercan.domain.tienda.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.tienda.value.FechaPago;
import com.example.cibercan.domain.tienda.value.VendedorId;
import com.example.cibercan.genericvalues.Email;
import com.example.cibercan.genericvalues.Nombre;
import com.example.cibercan.genericvalues.Telefono;

public class VendedorAsignado extends DomainEvent {

    private final VendedorId vendedorId;
    private final Email email;
    private final Telefono telefono;
    private final Nombre nombre;
    private final FechaPago fechaPago;

    public VendedorAsignado(VendedorId vendedorId, Email email, Telefono telefono, Nombre nombre, FechaPago fechaPago) {
        super("sofka.tienda.vendedorasignado");
        this.vendedorId = vendedorId;
        this.email = email;
        this.telefono = telefono;
        this.nombre = nombre;
        this.fechaPago = fechaPago;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
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
}
