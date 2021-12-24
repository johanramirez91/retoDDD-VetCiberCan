package com.example.cibercan.domain.adopcion.command;

import co.com.sofka.domain.generic.Command;
import com.example.cibercan.domain.adopcion.value.AdopcionId;
import com.example.cibercan.domain.adopcion.value.ContratoId;
import com.example.cibercan.domain.adopcion.value.DocumentoContrato;
import com.example.cibercan.genericvalues.Fecha;

public class AgregarContrato extends Command {

    private final AdopcionId adopcionId;
    private final ContratoId contratoId;
    private final DocumentoContrato documentoContrato;
    private final Fecha fecha;

    public AgregarContrato(AdopcionId adopcionId, ContratoId contratoId, DocumentoContrato documentoContrato, Fecha fecha) {
        this.adopcionId = adopcionId;
        this.contratoId = contratoId;
        this.documentoContrato = documentoContrato;
        this.fecha = fecha;
    }

    public AdopcionId getAdopcionId() {
        return adopcionId;
    }

    public ContratoId getContratoId() {
        return contratoId;
    }

    public DocumentoContrato getDocumentoContrato() {
        return documentoContrato;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
