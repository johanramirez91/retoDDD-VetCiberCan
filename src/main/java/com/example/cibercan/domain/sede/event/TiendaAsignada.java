package com.example.cibercan.domain.sede.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.tienda.value.TiendaId;

public class TiendaAsignada extends DomainEvent {

    private final TiendaId tiendaId;

    public TiendaAsignada(TiendaId tiendaId) {
        super("sofka.sede.tiendaasignada");
        this.tiendaId = tiendaId;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }


}
