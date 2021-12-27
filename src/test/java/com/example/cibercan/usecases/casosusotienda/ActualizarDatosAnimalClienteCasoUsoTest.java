package com.example.cibercan.usecases.casosusotienda;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.tienda.command.ActualizarDatosAnimalCliente;
import com.example.cibercan.domain.tienda.event.AnimalClienteAsignado;
import com.example.cibercan.domain.tienda.event.DatosAnimalClienteActualizados;
import com.example.cibercan.domain.tienda.event.TiendaCreada;
import com.example.cibercan.domain.tienda.value.*;
import com.example.cibercan.genericvalues.Nombre;
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
class ActualizarDatosAnimalClienteCasoUsoTest {

    private ActualizarDatosAnimalClienteCasoUso actualizarDatosAnimalClienteCasoUso;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void config(){
        actualizarDatosAnimalClienteCasoUso = new ActualizarDatosAnimalClienteCasoUso();
        repository = mock(DomainEventRepository.class);
        actualizarDatosAnimalClienteCasoUso.addRepository(repository);
    }

    @Test
    public void actualizarDatosAnimalCliente(){

        //Arrange
        var command = new ActualizarDatosAnimalCliente(
                TiendaId.of("CiberCan"),
                AnimalClienteId.of("007"),
                new Nombre("Jackie"),
                new EdadAnimalCliente(14),
                new PesoAnimal(11F),
                new Raza("Cocker spaniel")
        );
        var casoUso = new ActualizarDatosAnimalClienteCasoUso();
        Mockito.when(repository.getEventsBy("CiberCan")).thenReturn(events());
        casoUso.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("CiberCan")
                .syncExecutor(casoUso, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var datosAnimalActualizados = (DatosAnimalClienteActualizados) events.get(0);
        Assertions.assertEquals("007", datosAnimalActualizados.getAnimalClienteId().value());
        Assertions.assertEquals("Jackie", datosAnimalActualizados.getNombre().value());
        Assertions.assertEquals(14, datosAnimalActualizados.getEdadAnimalCliente().value());
        Assertions.assertEquals(11F, datosAnimalActualizados.getPesoAnimal().value());
        Assertions.assertEquals("Cocker spaniel", datosAnimalActualizados.getRaza().value());
    }

    private List<DomainEvent> events(){
        return List.of(new TiendaCreada(
                new Nombre("CiberCan")),

                new AnimalClienteAsignado(
                        new AnimalClienteId("007"),
                        new Nombre("Jack"),
                        new EdadAnimalCliente(12),
                        new PesoAnimal(14F),
                        new Raza("Cocker"))
                );
    }
}