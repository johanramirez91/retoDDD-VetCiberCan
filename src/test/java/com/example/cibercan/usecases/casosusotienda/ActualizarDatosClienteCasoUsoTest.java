package com.example.cibercan.usecases.casosusotienda;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.tienda.command.ActualizarDatosCliente;
import com.example.cibercan.domain.tienda.event.ClienteAsignado;
import com.example.cibercan.domain.tienda.event.DatosClienteActualizados;
import com.example.cibercan.domain.tienda.event.TiendaCreada;
import com.example.cibercan.domain.tienda.value.*;
import com.example.cibercan.genericvalues.Email;
import com.example.cibercan.genericvalues.Nombre;
import com.example.cibercan.genericvalues.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ActualizarDatosClienteCasoUsoTest {

    private ActualizarDatosClienteCasoUso actualizarDatosClienteCasoUso;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void config(){
        actualizarDatosClienteCasoUso = new ActualizarDatosClienteCasoUso();
        repository = mock(DomainEventRepository.class);
        actualizarDatosClienteCasoUso.addRepository(repository);
    }

    @Test
    public void actualizarDatosCliente(){

        //Arrange
        var command = new ActualizarDatosCliente(
                TiendaId.of("Cibercan"),
                ClienteId.of("c050"),
                new Nombre("Laura Diaz"),
                new Email("lalidihe@gmail.com"),
                new Telefono("3208532360"),
                new PagoDinero(4000D),
                new Descuento(500D)
        );
        var casoUso = new ActualizarDatosClienteCasoUso();
        Mockito.when(repository.getEventsBy("Cibercan")).thenReturn(events());
        casoUso.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("CiberCan")
                .syncExecutor(casoUso, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var datosClienteActualizados = (DatosClienteActualizados) events.get(0);
        Assertions.assertEquals("c050", datosClienteActualizados.getClienteId().value());
        Assertions.assertEquals("Laura Diaz", datosClienteActualizados.getNombre().value());
        Assertions.assertEquals("lalidihe@gmail.com", datosClienteActualizados.getEmail().value());
        Assertions.assertEquals("3208532360", datosClienteActualizados.getTelefono().value());
        Assertions.assertEquals(4000D, datosClienteActualizados.getPagoDinero().value());
        Assertions.assertEquals(500D, datosClienteActualizados.getDescuento().value());

    }

    private List<DomainEvent> events(){
        return List.of(new TiendaCreada(
                        new Nombre("CiberCan")),

                new ClienteAsignado(
                        ClienteId.of("c050"),
                        new Nombre("Johan Ramirez"),
                        new Email("johan911019@gmail.com"),
                        new Telefono("3008544796"),
                        new PagoDinero(35000D),
                        new Descuento(5000D))
        );
    }
}