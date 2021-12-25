package com.example.cibercan.usecases.casosusosede;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.cibercan.domain.sede.Sede;
import com.example.cibercan.domain.sede.command.CrearSede;

public class CrearSedeCasoUso extends UseCase<RequestCommand<CrearSede>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearSede> crearSedeRequestCommand) {
        var command = crearSedeRequestCommand.getCommand();
        var sede = new Sede(command.getSedeId(), command.getNombre(), command.getTelefono(), command.getDireccion());
        emit().onResponse(new ResponseEvents(sede.getUncommittedChanges()));
    }
}
