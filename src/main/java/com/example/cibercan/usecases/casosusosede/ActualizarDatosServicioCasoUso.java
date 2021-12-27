package com.example.cibercan.usecases.casosusosede;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.cibercan.domain.sede.Sede;
import com.example.cibercan.domain.sede.command.ActualizarDatosServicio;

public class ActualizarDatosServicioCasoUso extends UseCase<RequestCommand<ActualizarDatosServicio>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarDatosServicio> actualizarDatosServicioRequestCommand) {
        var command = actualizarDatosServicioRequestCommand.getCommand();
        var actualizacionServicio = Sede.from(command.getSedeId(), retrieveEvents(command.getSedeId().value()));
        actualizacionServicio.actualizarDatosServicio(command.getServicioId(), command.getDescripcion());
        emit().onResponse(new ResponseEvents(actualizacionServicio.getUncommittedChanges()));
    }
}
