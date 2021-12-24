package com.example.cibercan.domain.adopcion;

import co.com.sofka.domain.generic.Entity;
import com.example.cibercan.domain.adopcion.value.ContratoId;
import com.example.cibercan.domain.adopcion.value.DocumentoContrato;
import com.example.cibercan.genericvalues.Fecha;

import java.util.Objects;

public class Contrato extends Entity<ContratoId> {

    private DocumentoContrato documentoContrato;
    private Fecha fecha;

    public Contrato(ContratoId contratoId, DocumentoContrato documentoContrato, Fecha fecha) {
        super(contratoId);
        this.documentoContrato = documentoContrato;
        this.fecha = fecha;
    }

    public void actualizarDocumentoContrato(DocumentoContrato documentoContrato, Fecha fecha){
        this.documentoContrato = Objects.requireNonNull(documentoContrato, "El documento no puede ser nulo");
        this.fecha = Objects.requireNonNull(fecha, "La fecha no puede ser nula");
    }

    public DocumentoContrato DocumentoContrato() {
        return documentoContrato;
    }

    public Fecha Fecha() {
        return fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Contrato contrato = (Contrato) o;
        return Objects.equals(documentoContrato, contrato.documentoContrato) && Objects.equals(fecha, contrato.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), documentoContrato, fecha);
    }
}
