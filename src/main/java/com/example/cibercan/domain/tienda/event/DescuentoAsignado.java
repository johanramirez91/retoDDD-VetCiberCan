package com.example.cibercan.domain.tienda.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.tienda.value.ClienteId;
import com.example.cibercan.domain.tienda.value.Descuento;

public class DescuentoAsignado extends DomainEvent {

    private final ClienteId clienteId;
    private final Descuento descuento;

    public DescuentoAsignado(ClienteId clienteId, Descuento descuento) {
        super("sofka.tienda.descuentoasignado");
        this.clienteId = clienteId;
        this.descuento = descuento;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Descuento getDescuento() {
        return descuento;
    }
}
