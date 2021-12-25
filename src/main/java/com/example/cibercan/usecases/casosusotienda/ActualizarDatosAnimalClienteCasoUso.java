package com.example.cibercan.usecases.casosusotienda;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.cibercan.domain.tienda.Tienda;
import com.example.cibercan.domain.tienda.command.ActualizarDatosAnimalCliente;

public class ActualizarDatosAnimalClienteCasoUso extends UseCase<RequestCommand<ActualizarDatosAnimalCliente>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarDatosAnimalCliente> actualizarDatosAnimalClienteRequestCommand) {
        var command = actualizarDatosAnimalClienteRequestCommand.getCommand();
        var tienda = Tienda.from(command.getTiendaId(), retrieveEvents(command.getTiendaId().value()));
        tienda.actualizarDatosAnimalCliente(command.getAnimalClienteId(), command.getNombre(), command.getPesoAnimal(), command.getRaza(), command.getEdadAnimalCliente());
        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
