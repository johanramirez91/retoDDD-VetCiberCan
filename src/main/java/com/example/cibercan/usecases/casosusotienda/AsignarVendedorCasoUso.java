package com.example.cibercan.usecases.casosusotienda;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.cibercan.domain.tienda.Tienda;
import com.example.cibercan.domain.tienda.command.AsignarVendedor;

public class AsignarVendedorCasoUso extends UseCase<RequestCommand<AsignarVendedor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarVendedor> asignarVendedorRequestCommand) {
        var command = asignarVendedorRequestCommand.getCommand();
        var tienda = Tienda.from(command.getTiendaId(), retrieveEvents(command.getTiendaId().value()));
        tienda.asignarVendedor(command.getVendedorId(), command.getNombre(), command.getTelefono(), command.getEmail(), command.getFechaPago());
        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
