package com.example.cibercan.domain.sede.command;

import co.com.sofka.domain.generic.Command;
import com.example.cibercan.domain.sede.value.SedeId;
import com.example.cibercan.domain.tienda.value.TiendaId;

public class AsignarTienda extends Command {

    private final SedeId sedeId;
    private final TiendaId tiendaId;

    public AsignarTienda(SedeId sedeId, TiendaId tiendaId) {
        this.sedeId = sedeId;
        this.tiendaId = tiendaId;
    }

    public SedeId getSedeId() {
        return sedeId;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }
}
