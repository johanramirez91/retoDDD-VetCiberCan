package com.example.cibercan.usecases.casosusotienda;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.tienda.command.AsignarCliente;
import com.example.cibercan.domain.tienda.event.ClienteAsignado;
import com.example.cibercan.domain.tienda.event.TiendaCreada;
import com.example.cibercan.domain.tienda.value.ClienteId;
import com.example.cibercan.domain.tienda.value.Descuento;
import com.example.cibercan.domain.tienda.value.PagoDinero;
import com.example.cibercan.domain.tienda.value.TiendaId;
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
class AsignarClienteCasoUsoTest {

    private AsignarClienteCasoUso asignarClienteCasoUso;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void config(){
        asignarClienteCasoUso = new AsignarClienteCasoUso();
        repository = mock(DomainEventRepository.class);
        asignarClienteCasoUso.addRepository(repository);
    }

    @Test
    public void asignarCliente(){

        //Arrange
        var command = new AsignarCliente(
                TiendaId.of("CiberCan"),
                ClienteId.of("c020"),
                new Nombre("Nancy Martinez"),
                new PagoDinero(50000D),
                new Email("nancy@gmail.com"),
                new Telefono("3118532356"),
                new Descuento(1000D)
        );
        var casoUso = new AsignarClienteCasoUso();
        Mockito.when(repository.getEventsBy("CiberCan")).thenReturn(events());
        casoUso.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("CiberCan")
                .syncExecutor(casoUso, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var clienteAsignado = (ClienteAsignado) events.get(0);
        Assertions.assertEquals("c020", clienteAsignado.getClienteId().value());
        Assertions.assertEquals("Nancy Martinez", clienteAsignado.getNombre().value());
        Assertions.assertEquals(50000D, clienteAsignado.getPagoDinero().value());
        Assertions.assertEquals("nancy@gmail.com", clienteAsignado.getEmail().value());
        Assertions.assertEquals("3118532356", clienteAsignado.getTelefono().value());
        Assertions.assertEquals(1000D, clienteAsignado.getDescuento().value());
    }

    private List<DomainEvent> events(){
        return List.of(new TiendaCreada(
                new Nombre("CiberCan")
        ));
    }
}