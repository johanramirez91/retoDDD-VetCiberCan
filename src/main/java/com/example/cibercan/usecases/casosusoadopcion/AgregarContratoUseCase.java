package com.example.cibercan.usecases.casosusoadopcion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.cibercan.domain.adopcion.Adopcion;
import com.example.cibercan.domain.adopcion.command.AgregarContrato;

public class AgregarContratoUseCase extends UseCase<RequestCommand<AgregarContrato>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarContrato> agregarContratoRequestCommand) {
        var command = agregarContratoRequestCommand.getCommand();
        var adopcion = Adopcion.from(command.getAdopcionId(), retrieveEvents(command.getContratoId().value()));
        adopcion.agregarContrato(command.getContratoId(), command.getDocumentoContrato(), command.getFecha());
        emit().onResponse(new ResponseEvents(adopcion.getUncommittedChanges()));
    }
}
