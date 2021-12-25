package com.example.cibercan.usecases.casosusotienda;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.cibercan.domain.tienda.Tienda;
import com.example.cibercan.domain.tienda.command.AsignarCliente;

public class AsignarClienteCasoUso extends UseCase<RequestCommand<AsignarCliente>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarCliente> asignarClienteRequestCommand) {
        var command = asignarClienteRequestCommand.getCommand();
        var tienda = Tienda.from(command.getTiendaId(), retrieveEvents(command.getTiendaId().value()));
        tienda.asignarCliente(command.getClienteId(), command.getNombre(), command.getEmail(), command.getTelefono(), command.getPagoDinero(), command.getDescuento());
        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
