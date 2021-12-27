package com.example.cibercan.usecases.casosusosede;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.sede.command.AgregarProducto;
import com.example.cibercan.domain.sede.event.ProductoAgregado;
import com.example.cibercan.domain.sede.event.SedeCreada;
import com.example.cibercan.domain.sede.value.*;
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
class AgregarProductosCasoUsoTest {

    private AgregarProductosCasoUso agregarProductosCasoUso;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void config(){
        agregarProductosCasoUso = new AgregarProductosCasoUso();
        repository = mock(DomainEventRepository.class);
        agregarProductosCasoUso.addRepository(repository);
    }

    @Test
    public void agregarProducto(){

        //Arrange
        var command = new AgregarProducto(
                SedeId.of("abc123456"),
                new ProductoId("001"),
                new Nombre("Shampoo"),
                new Precio(35000D),
                new Cantidad(10)
        );

        var casoUso = new  AgregarProductosCasoUso();
        Mockito.when(repository.getEventsBy("abc123456")).thenReturn(events());
        casoUso.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("abc123456")
                .syncExecutor(casoUso, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var productoAgregadoEvent = (ProductoAgregado) events.get(0);
        Assertions.assertEquals("001", productoAgregadoEvent.getProductoId().value());
        Assertions.assertEquals("shampoo", productoAgregadoEvent.getNombre().value().toLowerCase());
        Assertions.assertEquals(35000, productoAgregadoEvent.getPrecio().value().doubleValue());
        Assertions.assertEquals(10, productoAgregadoEvent.getCantidad().value());
    }

    private List<DomainEvent> events(){
        return List.of(new SedeCreada(
                new Nombre("Chapinero"),
                new Telefono("3001234567"),
                new Direccion("Carrera 7 # 64 - 65")
        ));
    }

}