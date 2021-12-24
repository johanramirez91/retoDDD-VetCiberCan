package com.example.cibercan.domain.tienda.command;

import co.com.sofka.domain.generic.Command;
import com.example.cibercan.domain.tienda.value.TiendaId;
import com.example.cibercan.genericvalues.Nombre;

public class CrearTienda extends Command {

    private final TiendaId tiendaId;
    private final Nombre nombre;

    public CrearTienda(TiendaId tiendaId, Nombre nombre) {
        this.tiendaId = tiendaId;
        this.nombre = nombre;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
