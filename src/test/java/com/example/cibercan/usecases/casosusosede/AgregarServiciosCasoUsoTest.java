package com.example.cibercan.usecases.casosusosede;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.sede.command.AgregarServicio;
import com.example.cibercan.domain.sede.event.SedeCreada;
import com.example.cibercan.domain.sede.event.ServicioAgregado;
import com.example.cibercan.domain.sede.value.Direccion;
import com.example.cibercan.domain.sede.value.SedeId;
import com.example.cibercan.domain.sede.value.ServicioId;
import com.example.cibercan.genericvalues.Descripcion;
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
class AgregarServiciosCasoUsoTest {

    private AgregarServiciosCasoUso agregarServiciosCasoUso;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void config(){
        agregarServiciosCasoUso = new AgregarServiciosCasoUso();
        repository = mock(DomainEventRepository.class);
        agregarServiciosCasoUso.addRepository(repository);
    }

    @Test
    public void agregarServicio(){

        //Arrange
        var command = new AgregarServicio(
                SedeId.of("abc123456"),
                new ServicioId("service001"),
                new Descripcion("Vacunacion")
        );

        var casoUso = new AgregarServiciosCasoUso();
        Mockito.when(repository.getEventsBy("abc123456")).thenReturn(events());
        casoUso.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("abc123456")
                .syncExecutor(casoUso, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var servicioAgregadoEvent = (ServicioAgregado) events.get(0);
        Assertions.assertEquals("service001", servicioAgregadoEvent.getServicioId().value());
        Assertions.assertEquals("vacunacion", servicioAgregadoEvent.getDescripcion().value().toLowerCase());
    }

    private List<DomainEvent> events(){
        return List.of(new SedeCreada(
                new Nombre("Chapinero"),
                new Telefono("3001234567"),
                new Direccion("Carrera 7 # 64 - 65")
        ));
    }

}