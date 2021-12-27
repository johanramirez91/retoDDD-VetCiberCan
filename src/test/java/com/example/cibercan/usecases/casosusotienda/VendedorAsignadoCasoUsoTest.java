package com.example.cibercan.usecases.casosusotienda;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.tienda.event.TiendaCreada;
import com.example.cibercan.domain.tienda.event.VendedorAsignado;
import com.example.cibercan.domain.tienda.value.FechaPago;
import com.example.cibercan.domain.tienda.value.VendedorId;
import com.example.cibercan.genericvalues.Email;
import com.example.cibercan.genericvalues.Nombre;
import com.example.cibercan.genericvalues.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VendedorAsignadoCasoUsoTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarVendedor(){
        var event = new VendedorAsignado(
                VendedorId.of("v004"),
                new Email("vendedor@cibercan.com"),
                new Telefono("3118635327"),
                new Nombre("David"),
                new FechaPago(30,12,2021)
        );
        event.setAggregateRootId("tienda online");
        var casoUso = new VendedorAsignadoCasoUso();

        Mockito.when(repository.getEventsBy("tienda online")).thenReturn(events());
        casoUso.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("tienda online")
                .syncExecutor(casoUso, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var vendedorAsignadoEvent = (VendedorAsignado) events.get(0);
        Assertions.assertEquals("3118635327", vendedorAsignadoEvent.getTelefono().value());
        Assertions.assertEquals("vendedor@cibercan.com", vendedorAsignadoEvent.getEmail().value());
        Assertions.assertEquals("David", vendedorAsignadoEvent.getNombre().value());
        Assertions.assertEquals("v004", vendedorAsignadoEvent.getVendedorId().value());
        Assertions.assertEquals("30-12-2021", vendedorAsignadoEvent.getFechaPago().value());
        Mockito.verify(repository).getEventsBy("tienda online");

    }

    private List<DomainEvent> events(){
        return List.of(
                new TiendaCreada(new Nombre("tienda online")),
                new VendedorAsignado(VendedorId.of("v004"),
                        new Email("vendedor@cibercan.com"),
                        new Telefono("3118635327"),
                        new Nombre("David"),
                        new FechaPago(30,12,2021))
        );
    }
}