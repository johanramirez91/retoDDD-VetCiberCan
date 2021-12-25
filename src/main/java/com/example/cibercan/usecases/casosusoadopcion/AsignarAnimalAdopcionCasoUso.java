package com.example.cibercan.usecases.casosusoadopcion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.cibercan.domain.adopcion.Adopcion;
import com.example.cibercan.domain.adopcion.command.AsignarAnimalAdopcion;

public class AsignarAnimalAdopcionCasoUso extends UseCase<RequestCommand<AsignarAnimalAdopcion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarAnimalAdopcion> asignarAnimalAdopcionRequestCommand) {
        var command = asignarAnimalAdopcionRequestCommand.getCommand();
        var adopcion = Adopcion.from(command.getAdopcionId(), retrieveEvents(command.getAnimalAdopcionId().value()));
        adopcion.asignarAnimalAdopcion(command.getAnimalAdopcionId(), command.getNombre(), command.getDiagnostico(), command.getDescripcion());
        emit().onResponse(new ResponseEvents(adopcion.getUncommittedChanges()));
    }
}
