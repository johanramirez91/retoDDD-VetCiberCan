package com.example.cibercan.usecases.casosusosede;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.example.cibercan.domain.sede.Sede;
import com.example.cibercan.domain.sede.event.ProductoAgregado;
import com.example.cibercan.domain.sede.value.Cantidad;
import com.example.cibercan.domain.sede.value.Precio;
import com.example.cibercan.domain.sede.value.ProductoId;
import com.example.cibercan.domain.sede.value.SedeId;
import com.example.cibercan.genericvalues.Nombre;

public class ProductoAgregadoCasoUso extends UseCase<TriggeredEvent<ProductoAgregado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<ProductoAgregado> productoAgregadoTriggeredEvent) {
        var event = productoAgregadoTriggeredEvent.getDomainEvent();
        var producto = Sede.from(SedeId.of(event.aggregateRootId()), this.retrieveEvents());
        producto.agregarProducto(ProductoId.of("prod035"),
                new Nombre("Antipulgas"),
                new Precio(10000D),
                new Cantidad(50));
        emit().onResponse(new ResponseEvents(producto.getUncommittedChanges()));
    }
}
