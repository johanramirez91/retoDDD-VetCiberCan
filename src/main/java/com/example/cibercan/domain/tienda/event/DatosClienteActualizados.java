package com.example.cibercan.domain.tienda.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.tienda.value.ClienteId;
import com.example.cibercan.domain.tienda.value.Descuento;
import com.example.cibercan.domain.tienda.value.PagoDinero;
import com.example.cibercan.genericvalues.Email;
import com.example.cibercan.genericvalues.Nombre;
import com.example.cibercan.genericvalues.Telefono;

public class DatosClienteActualizados extends DomainEvent {

    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Email email;
    private final Telefono telefono;
    private final PagoDinero pagoDinero;
    private final Descuento descuento;

    public DatosClienteActualizados(ClienteId clienteId, Nombre nombre, PagoDinero pagoDinero, Email email, Telefono telefono, Descuento descuento) {
        super("sofka.tienda.datosclienteactualizados");
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.pagoDinero = pagoDinero;
        this.email = email;
        this.telefono = telefono;
        this.descuento = descuento;
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
