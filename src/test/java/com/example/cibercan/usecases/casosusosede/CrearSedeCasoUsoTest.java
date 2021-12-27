package com.example.cibercan.usecases.casosusosede;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.example.cibercan.domain.sede.command.CrearSede;
import com.example.cibercan.domain.sede.event.SedeCreada;
import com.example.cibercan.domain.sede.value.Direccion;
import com.example.cibercan.domain.sede.value.SedeId;
import com.example.cibercan.genericvalues.Nombre;
import com.example.cibercan.genericvalues.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearSedeCasoUsoTest {

    @Test
    public void crearSede(){

        //Arrange
        var command = new CrearSede(
                SedeId.of("abc123456"),
                new Nombre("Chapinero"),
                new Telefono("3208532360"),
                new Direccion("Carrera 7 # 64 - 65")
        );
        var casoUso = new CrearSedeCasoUso();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(casoUso, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (SedeCreada) events.get(0);
        Assertions.assertEquals("chapinero", event.getNombre().value().toLowerCase());
        Assertions.assertEquals("3208532360", event.getTelefono().value());
        Assertions.assertEquals("Carrera 7 # 64 - 65", event.getDireccion().value());
    }

}