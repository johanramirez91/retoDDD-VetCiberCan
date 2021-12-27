package com.example.cibercan.usecases.casosusosede;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.sede.command.ActualizarDatosServicio;
import com.example.cibercan.domain.sede.event.DatosServicioActualizados;
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

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ActualizarDatosServicioCasoUsoTest {

    private ActualizarDatosServicioCasoUso actualizarDatosServicioCasoUso;

   @Mock
   private DomainEventRepository repository;

   @BeforeEach
    public void config(){
       actualizarDatosServicioCasoUso = new ActualizarDatosServicioCasoUso();
       repository = mock(DomainEventRepository.class);
       actualizarDatosServicioCasoUso.addRepository(repository);
   }

   @Test
    void actualizarDatosVeterinario(){

       //Arrange
       var command = new ActualizarDatosServicio(
               SedeId.of("abc123456"),
               ServicioId.of("A150"),
               new Descripcion("Jornada Vacunación promocion")
       );

       var casoUso = new ActualizarDatosServicioCasoUso();
       Mockito.when(repository.getEventsBy("abc123456")).thenReturn(events());
       casoUso.addRepository(repository);

       //Act
       var events = UseCaseHandler.getInstance()
               .setIdentifyExecutor("abc123456")
               .syncExecutor(casoUso, new RequestCommand<>(command))
               .orElseThrow()
               .getDomainEvents();

       //Assert
       var servicioActualizadoEvent = (DatosServicioActualizados) events.get(0);
       Assertions.assertEquals("A150", servicioActualizadoEvent.getServicioId().value());
       Assertions.assertEquals("Jornada Vacunación promocion", servicioActualizadoEvent.getDescripcion().value());
   }

    private List<DomainEvent> events(){
        return List.of(new SedeCreada(
                new Nombre("Chapinero"),
                new Telefono("3001234567"),
                new Direccion("Carrera 7 # 64 - 65")),

                new ServicioAgregado(
                        ServicioId.of("A150"),
                        new Descripcion("Vacunacion")
                ));
    }
}