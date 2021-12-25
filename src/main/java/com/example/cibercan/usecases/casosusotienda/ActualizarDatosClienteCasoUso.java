package com.example.cibercan.usecases.casosusotienda;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.cibercan.domain.tienda.Tienda;
import com.example.cibercan.domain.tienda.command.ActualizarDatosCliente;

public class ActualizarDatosClienteCasoUso extends UseCase<RequestCommand<ActualizarDatosCliente>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarDatosCliente> actualizarDatosClienteRequestCommand) {
        var command = actualizarDatosClienteRequestCommand.getCommand();
        var tienda = Tienda.from(command.getTiendaId(), retrieveEvents(command.getTiendaId().value()));
        tienda.actualizarDatosCliente(command.getClienteId(), command.getNombre(), command.getEmail(), command.getTelefono(), command.getPagoDinero(), command.getDescuento());
        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
