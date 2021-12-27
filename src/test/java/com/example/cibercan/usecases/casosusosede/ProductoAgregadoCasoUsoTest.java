package com.example.cibercan.usecases.casosusosede;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.sede.event.ProductoAgregado;
import com.example.cibercan.domain.sede.event.SedeCreada;
import com.example.cibercan.domain.sede.value.Cantidad;
import com.example.cibercan.domain.sede.value.Direccion;
import com.example.cibercan.domain.sede.value.Precio;
import com.example.cibercan.domain.sede.value.ProductoId;
import com.example.cibercan.genericvalues.Nombre;
import com.example.cibercan.genericvalues.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProductoAgregadoCasoUsoTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarProducto() {

        //Arrange
        var event = new ProductoAgregado(
                ProductoId.of("prod035"),
                new Nombre("Antipulgas"),
                new Cantidad(50),
                new Precio(10000D)
        );
        event.setAggregateRootId("CiberCan");
        var casoUso = new ProductoAgregadoCasoUso();

        Mockito.when(repository.getEventsBy("CiberCan")).thenReturn(events());
        casoUso.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("CiberCan")
                .syncExecutor(casoUso, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var productoAsignadoEvent = (ProductoAgregado) events.get(0);
        Assertions.assertEquals("prod035", productoAsignadoEvent.getProductoId().value());
        Assertions.assertEquals("Antipulgas", productoAsignadoEvent.getNombre().value());
        Assertions.assertEquals(50, productoAsignadoEvent.getCantidad().value());
        Assertions.assertEquals(10000D, productoAsignadoEvent.getPrecio().value());
    }

    private List<DomainEvent> events() {
        return List.of(
                new SedeCreada(new Nombre("Chapinero"),
                        new Telefono("3008544796"),
                        new Direccion("Carrera 7 # 64-65")),
                new ProductoAgregado(ProductoId.of("prod035"),
                        new Nombre("Antipulgas"),
                        new Cantidad(50),
                        new Precio(10000D))
        );
    }

}