package com.example.cibercan.usecases.casosusosede;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.cibercan.domain.sede.Sede;
import com.example.cibercan.domain.sede.command.AgregarServicio;

public class AgregarServiciosCasoUso extends UseCase<RequestCommand<AgregarServicio>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarServicio> agregarServicioRequestCommand) {
        var command = agregarServicioRequestCommand.getCommand();
        var servicio = Sede.from(command.getSedeId(), retrieveEvents(command.getSedeId().value()));
        servicio.agregarServicio(command.getServicioId(), command.getDescripcion());
        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
