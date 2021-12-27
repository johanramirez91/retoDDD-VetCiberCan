package com.example.cibercan.usecases.casosusosede;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.sede.command.AsignarVeterinario;
import com.example.cibercan.domain.sede.event.SedeCreada;
import com.example.cibercan.domain.sede.event.VeterinarioAsignado;
import com.example.cibercan.domain.sede.value.Direccion;
import com.example.cibercan.domain.sede.value.SedeId;
import com.example.cibercan.domain.sede.value.VeterinarioId;
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
class AsignarVeterinarioCasoUsoTest {

    private AsignarVeterinarioCasoUso asignarVeterinarioCasoUso;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void config(){
        asignarVeterinarioCasoUso = new AsignarVeterinarioCasoUso();
        repository = mock(DomainEventRepository.class);
        asignarVeterinarioCasoUso.addRepository(repository);
    }

    @Test
    public void asignarVeterinario(){

        //Arrange
        var command = new AsignarVeterinario(
                SedeId.of("abc123456"),
                new VeterinarioId("005"),
                new Nombre("Johan"),
                new Email("johanvet@veterinariacibercan.com.co"),
                new Telefono("3008544796")
        );

        var casoUso = new AsignarVeterinarioCasoUso();
        Mockito.when(repository.getEventsBy("abc123456")).thenReturn(events());
        casoUso.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("abc123456")
                .syncExecutor(casoUso, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var veterinarioAsignadoEvent = (VeterinarioAsignado) events.get(0);
        Assertions.assertEquals("005", veterinarioAsignadoEvent.getVeterinarioId().value());
        Assertions.assertEquals("johan", veterinarioAsignadoEvent.getNombre().value().toLowerCase());
        Assertions.assertEquals("johanvet@veterinariacibercan.com.co", veterinarioAsignadoEvent.getEmail().value());
        Assertions.assertEquals("3008544796", veterinarioAsignadoEvent.getTelefono().value());
    }

    private List<DomainEvent> events(){
        return List.of(new SedeCreada(
                new Nombre("Chapinero"),
                new Telefono("3001234567"),
                new Direccion("Carrera 7 # 64 - 65")
        ));
    }
}