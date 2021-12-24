package com.example.cibercan.domain.tienda.command;

import co.com.sofka.domain.generic.Command;
import com.example.cibercan.domain.tienda.value.ClienteId;
import com.example.cibercan.domain.tienda.value.Descuento;
import com.example.cibercan.domain.tienda.value.TiendaId;

public class AsignarDescuento extends Command {

    private final TiendaId tiendaId;
    private final ClienteId clienteId;
    private final Descuento descuento;

    public AsignarDescuento(TiendaId tiendaId, ClienteId clienteId, Descuento descuento) {
        this.tiendaId = tiendaId;
        this.clienteId = clienteId;
        this.descuento = descuento;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Descuento getDescuento() {
        return descuento;
    }
}
