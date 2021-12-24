package com.example.cibercan.domain.adopcion.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.adopcion.value.ContratoId;
import com.example.cibercan.domain.adopcion.value.DocumentoContrato;
import com.example.cibercan.genericvalues.Fecha;

public class ContratoAgregado extends DomainEvent {

    private final ContratoId contratoId;
    private final DocumentoContrato contrato;
    private final Fecha fecha;

    public ContratoAgregado(ContratoId contratoId, DocumentoContrato contrato, Fecha fecha) {
        super("sofka.adopcion.contradoagregado");
        this.contratoId = contratoId;
        this.contrato = contrato;
        this.fecha = fecha;
    }

    public ContratoId getContratoId() {
        return contratoId;
    }

    public DocumentoContrato getContrato() {
        return contrato;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
