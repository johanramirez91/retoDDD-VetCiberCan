package com.example.cibercan.usecases.casosusosede;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.cibercan.domain.sede.Sede;
import com.example.cibercan.domain.sede.command.AgregarProducto;

public class AgregarProductosCasoUso extends UseCase<RequestCommand<AgregarProducto>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarProducto> agregarProductoRequestCommand) {
        var command = agregarProductoRequestCommand.getCommand();
        var producto = Sede.from(command.getSedeId(), retrieveEvents(command.getSedeId().value()));
        producto.agregarProducto(command.getProductoId(), command.getNombre(), command.getPrecio(), command.getCantidad());
        if(producto.Productos().size() > 500){
            throw  new BusinessException(command.getProductoId().value(), "No es posible agregar mas de 500 productos");
        }
        emit().onResponse(new ResponseEvents(producto.getUncommittedChanges()));
    }
}
