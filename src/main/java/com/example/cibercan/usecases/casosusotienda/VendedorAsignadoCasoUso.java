package com.example.cibercan.usecases.casosusotienda;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.example.cibercan.domain.tienda.Tienda;
import com.example.cibercan.domain.tienda.event.VendedorAsignado;
import com.example.cibercan.domain.tienda.value.FechaPago;
import com.example.cibercan.domain.tienda.value.TiendaId;
import com.example.cibercan.domain.tienda.value.VendedorId;
import com.example.cibercan.genericvalues.Email;
import com.example.cibercan.genericvalues.Nombre;
import com.example.cibercan.genericvalues.Telefono;

public class VendedorAsignadoCasoUso extends UseCase<TriggeredEvent<VendedorAsignado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<VendedorAsignado> vendedorAsignadoTriggeredEvent) {
        var event = vendedorAsignadoTriggeredEvent.getDomainEvent();
        var vendedor = Tienda.from(TiendaId.of(event.aggregateRootId()), this.retrieveEvents());
        vendedor.asignarVendedor(VendedorId.of("v004"),
                new Nombre("David"),
                new Telefono("3118635327"),
                new Email("vendedor@cibercan.com"),
                new FechaPago(30, 12, 2021));
        emit().onResponse(new ResponseEvents(vendedor.getUncommittedChanges()));
    }
}
