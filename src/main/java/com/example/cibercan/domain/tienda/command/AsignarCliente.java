package com.example.cibercan.domain.tienda.command;

import co.com.sofka.domain.generic.Command;
import com.example.cibercan.domain.tienda.value.ClienteId;
import com.example.cibercan.domain.tienda.value.Descuento;
import com.example.cibercan.domain.tienda.value.PagoDinero;
import com.example.cibercan.domain.tienda.value.TiendaId;
import com.example.cibercan.genericvalues.Email;
import com.example.cibercan.genericvalues.Nombre;
import com.example.cibercan.genericvalues.Telefono;

public class AsignarCliente extends Command {

    private final TiendaId tiendaId;
    private final ClienteId clienteId;
    private final Nombre nombre;
    private final PagoDinero pagoDinero;
    private final Email email;
    private final Telefono telefono;
    private final Descuento descuento;

    public AsignarCliente(TiendaId tiendaId, ClienteId clienteId, Nombre nombre, PagoDinero pagoDinero, Email email, Telefono telefono, Descuento descuento) {
        this.tiendaId = tiendaId;
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.pagoDinero = pagoDinero;
        this.email = email;
        this.telefono = telefono;
        this.descuento = descuento;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public PagoDinero getPagoDinero() {
        return pagoDinero;
    }

    public Email getEmail() {
        return email;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Descuento getDescuento() {
        return descuento;
    }
}
