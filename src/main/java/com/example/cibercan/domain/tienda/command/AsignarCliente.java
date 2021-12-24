package com.example.cibercan.domain.tienda.command;

import co.com.sofka.domain.generic.Command;
import com.example.cibercan.domain.tienda.value.ClienteId;
import com.example.cibercan.domain.tienda.value.PagoDinero;
import com.example.cibercan.domain.tienda.value.TiendaId;
import com.example.cibercan.genericvalues.Nombre;

public class AsignarCliente extends Command {

    private final TiendaId tiendaId;
    private final ClienteId clienteId;
    private final Nombre nombre;
    private final PagoDinero pagoDinero;

    public AsignarCliente(TiendaId tiendaId, ClienteId clienteId, Nombre nombre, PagoDinero pagoDinero) {
        this.tiendaId = tiendaId;
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.pagoDinero = pagoDinero;
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
}
