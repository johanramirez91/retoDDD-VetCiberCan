package com.example.cibercan.domain.tienda.command;

import co.com.sofka.domain.generic.Command;
import com.example.cibercan.domain.tienda.value.FechaPago;
import com.example.cibercan.domain.tienda.value.TiendaId;
import com.example.cibercan.domain.tienda.value.VendedorId;
import com.example.cibercan.genericvalues.Email;
import com.example.cibercan.genericvalues.Nombre;
import com.example.cibercan.genericvalues.Telefono;

public class AsignarVendedor extends Command {

    private final TiendaId tiendaId;
    private final VendedorId vendedorId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Email email;
    private final FechaPago fechaPago;

    public AsignarVendedor(TiendaId tiendaId, VendedorId vendedorId, Nombre nombre, Telefono telefono, Email email, FechaPago fechaPago) {
        this.tiendaId = tiendaId;
        this.vendedorId = vendedorId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.fechaPago = fechaPago;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }

    public VendedorId getVendedorId() {
        return vendedorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Email getEmail() {
        return email;
    }

    public FechaPago getFechaPago() {
        return fechaPago;
    }
}
