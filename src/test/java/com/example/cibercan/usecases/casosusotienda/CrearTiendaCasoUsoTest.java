package com.example.cibercan.usecases.casosusotienda;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.example.cibercan.domain.tienda.command.CrearTienda;
import com.example.cibercan.domain.tienda.event.TiendaCreada;
import com.example.cibercan.domain.tienda.value.TiendaId;
import com.example.cibercan.genericvalues.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CrearTiendaCasoUsoTest {

    @Test
    void crearTienda() {

        //Arrange
        var command = new CrearTienda(
                TiendaId.of("CiberCan Online"),
                new Nombre("CiberCan tienda en linea")
        );
        var casoUso = new CrearTiendaCasoUso();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(casoUso, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var tiendaCreada = (TiendaCreada) events.get(0);
        Assertions.assertEquals("CiberCan tienda en linea", tiendaCreada.getNombre().value());
    }
}