package com.example.cibercan.domain.tienda.command;

import co.com.sofka.domain.generic.Command;
import com.example.cibercan.domain.tienda.value.ClienteId;
import com.example.cibercan.domain.tienda.value.Descuento;
import com.example.cibercan.domain.tienda.value.PagoDinero;
import com.example.cibercan.domain.tienda.value.TiendaId;
import com.example.cibercan.genericvalues.Email;
import com.example.cibercan.genericvalues.Nombre;
import com.example.cibercan.genericvalues.Telefono;

public class ActualizarDatosCliente extends Command {

    private final TiendaId tiendaId;
    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Email email;
    private final Telefono telefono;
    private final PagoDinero pagoDinero;
    private final Descuento descuento;

    public ActualizarDatosCliente(TiendaId tiendaId, ClienteId clienteId, Nombre nombre, Email email, Telefono telefono, PagoDinero pagoDinero, Descuento descuento) {
        this.tiendaId = tiendaId;
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.pagoDinero = pagoDinero;
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

    public Descuento getDescuento() {
        return descuento;
    }

    public Email getEmail() {
        return email;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
