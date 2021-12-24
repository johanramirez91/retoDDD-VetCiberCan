package com.example.cibercan.domain.adopcion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.adopcion.event.AnimalAdopcionAsignado;
import com.example.cibercan.domain.adopcion.event.ContratoAgregado;
import com.example.cibercan.domain.adopcion.event.SolicitudActualizada;
import com.example.cibercan.domain.adopcion.event.SolicitudCreada;
import com.example.cibercan.domain.adopcion.value.*;
import com.example.cibercan.genericvalues.Descripcion;
import com.example.cibercan.genericvalues.Fecha;
import com.example.cibercan.genericvalues.Nombre;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Adopcion extends AggregateEvent<AdopcionId> {

    protected Set<AnimalAdopcion> animalesAdopcion;
    protected Estado estado;
    protected Fecha fecha;
    protected Set<Contrato> contratos;
    protected Set<Solicitud> solicitudes;

    public Adopcion(AdopcionId adopcionId, SolicitudId solicitudId, Estado estado, Fecha fecha) {
        super(adopcionId);
        appendChange(new SolicitudCreada(solicitudId, estado, fecha)).apply();
    }

    private Adopcion(AdopcionId adopcionId){
        super(adopcionId);
        subscribe(new AdopcionChange(this));
    }

    public static Adopcion from(AdopcionId adopcionId, List<DomainEvent> events){
        var adopcion = new Adopcion(adopcionId);
        events.forEach(adopcion::applyEvent);
        return adopcion;
    }

    public void agregarContrato(ContratoId contratoId, DocumentoContrato documentoContrato, Fecha fecha){
        Objects.requireNonNull(contratoId, "El Id no puede ser nulo");
        Objects.requireNonNull(documentoContrato, "El documento no puede ser nulo");
        Objects.requireNonNull(fecha, "La fecha no puede ser nula");
        appendChange(new ContratoAgregado(contratoId, documentoContrato, fecha)).apply();
    }

    public void asignarAnimalAdopcion(AnimalAdopcionId animalAdopcionId, Nombre nombre, Diagnostico diagnostico, Descripcion descripcion){
        Objects.requireNonNull(animalAdopcionId, "El Id no puede ser nulo");
        Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        Objects.requireNonNull(diagnostico, "El diagnostico no puede ser nulo");
        Objects.requireNonNull(descripcion, "La descripción no puede ser nulo");
        appendChange(new AnimalAdopcionAsignado(animalAdopcionId, nombre, diagnostico, descripcion)).apply();
    }

    public void actualizarSolicitud(SolicitudId solicitudId, Estado.EstadoSoliciutd estado){
        Objects.requireNonNull(solicitudId, "El Id no puede ser nulo");
        Objects.requireNonNull(estado, "El Estado no puede ser nulo");
        appendChange(new SolicitudActualizada(estado, solicitudId)).apply();
    }

    public Optional<AnimalAdopcion> obtenerAnimalesPorId(AnimalAdopcionId animalAdopcionId){
        return AnimalesAdopcion().stream()
                .filter(animalAdopcion -> animalAdopcion.identity().equals(animalAdopcionId))
                .findFirst();
    }

    public Optional<Contrato> obtenerContratosPorId(ContratoId contratoId){
        return Contratos().stream()
                .filter(contrato -> contrato.identity().equals(contratoId))
                .findFirst();
    }

    public Optional<Solicitud> obtenerSolicitudesPorId(SolicitudId solicitudId){
        return Solicitudes().stream()
                .filter(solicitud -> solicitud.identity().equals(solicitudId))
                .findFirst();
    }

    public Set<AnimalAdopcion> AnimalesAdopcion() {
        return animalesAdopcion;
    }

    public Estado Estado() {
        return estado;
    }

    public Fecha Fecha() {
        return fecha;
    }

    public Set<Contrato> Contratos() {
        return contratos;
    }

    public Set<Solicitud> Solicitudes() {
        return solicitudes;
    }
}
