package com.example.cibercan.domain.adopcion;

import co.com.sofka.domain.generic.EventChange;
import com.example.cibercan.domain.adopcion.event.AnimalAdopcionAsignado;
import com.example.cibercan.domain.adopcion.event.ContratoAgregado;
import com.example.cibercan.domain.adopcion.event.SolicitudActualizada;
import com.example.cibercan.domain.adopcion.event.SolicitudCreada;

public class AdopcionChange extends EventChange {

    public AdopcionChange(Adopcion adopcion) {

        apply((SolicitudCreada event) -> {
            var solicitud = adopcion.obtenerSolicitudesPorId(event.getSolicitudId())
                    .orElseThrow(() -> new IllegalArgumentException("No existe solicitud con Id: " + event.getSolicitudId()));
            solicitud.actualizarSolicitud(solicitud.Estado());
        });

        apply((SolicitudActualizada event) ->{
            var solicitud = adopcion.obtenerSolicitudesPorId(event.getSolicitudId())
                    .orElseThrow(() -> new IllegalArgumentException("No existe solicitud con Id: " + event.getSolicitudId()));
            solicitud.actualizarSolicitud(solicitud.Estado());
        });

        apply((ContratoAgregado event) -> {
            var contrato = adopcion.obtenerContratosPorId(event.getContratoId())
                    .orElseThrow(() -> new IllegalArgumentException("No existe el contrato con Id: " + event.getContratoId()));
            contrato.actualizarDocumentoContrato(event.getContrato(), event.getFecha());
        });

        apply((AnimalAdopcionAsignado event) -> {
            var animalesAdopcion = adopcion.obtenerAnimalesPorId(event.getAnimalAdopcionId())
                    .orElseThrow(() -> new IllegalArgumentException("No existe animal con Id: " + event.getAnimalAdopcionId()));
            animalesAdopcion.actualizarNombreAnimalAdopcion(event.getNombre());
            animalesAdopcion.actualizarDescripcion(event.getDescripcion());
            animalesAdopcion.actualizarDiagnostico(event.getDiagnostico());
        });
    }
}
