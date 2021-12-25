package com.example.cibercan.usecases.casosusotienda;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.cibercan.domain.tienda.Tienda;
import com.example.cibercan.domain.tienda.command.CrearTienda;

public class CrearTiendaCasoUso extends UseCase<RequestCommand<CrearTienda>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearTienda> crearTiendaRequestCommand) {
        var command = crearTiendaRequestCommand.getCommand();
        var tienda = new Tienda(command.getTiendaId(), command.getNombre());
        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
