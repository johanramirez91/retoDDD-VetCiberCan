package com.example.cibercan.usecases.casosusotienda;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.tienda.command.AsignarAnimalCliente;
import com.example.cibercan.domain.tienda.event.AnimalClienteAsignado;
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
class AsignarAnimalClienteCasoUsoTest  {

    private AsignarAnimalClienteCasoUso asignarAnimalClienteCasoUso;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void config(){
        asignarAnimalClienteCasoUso = new AsignarAnimalClienteCasoUso();
        repository = mock(DomainEventRepository.class);
        asignarAnimalClienteCasoUso.addRepository(repository);
    }

    @Test
    public void asignarAnimalCliente(){

        //Arrange
        var command = new AsignarAnimalCliente(
                TiendaId.of("Cibercan"),
                AnimalClienteId.of("010"),
                new Nombre("Alaska"),
                new EdadAnimalCliente(11),
                new PesoAnimal(11F),
                new Raza("Cocker")
        );
        var casoUso = new AsignarAnimalClienteCasoUso();
        Mockito.when(repository.getEventsBy("Cibercan")).thenReturn(events());
        casoUso.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("CiberCan")
                .syncExecutor(casoUso, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var animalUsuarioAsignado = (AnimalClienteAsignado) events.get(0);
        Assertions.assertEquals("010", animalUsuarioAsignado.getAnimalClienteId().value());
        Assertions.assertEquals("Alaska", animalUsuarioAsignado.getNombre().value());
        Assertions.assertEquals(11, animalUsuarioAsignado.getEdadAnimalCliente().value());
        Assertions.assertEquals(11F, animalUsuarioAsignado.getPesoAnimal().value());
        Assertions.assertEquals("Cocker", animalUsuarioAsignado.getRaza().value());
    }

    private List<DomainEvent> events(){
        return List.of(new TiendaCreada(
                new Nombre("CiberCan")
        ));
    }
}