package com.example.cibercan.usecases.casosusotienda;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.tienda.command.AsignarVendedor;
import com.example.cibercan.domain.tienda.event.TiendaCreada;
import com.example.cibercan.domain.tienda.event.VendedorAsignado;
import com.example.cibercan.domain.tienda.value.FechaPago;
import com.example.cibercan.domain.tienda.value.TiendaId;
import com.example.cibercan.domain.tienda.value.VendedorId;
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

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class AsignarVendedorCasoUsoTest {

    private AsignarVendedorCasoUso asignarVendedorCasoUso;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void config() {
        asignarVendedorCasoUso = new AsignarVendedorCasoUso();
        repository = mock(DomainEventRepository.class);
        asignarVendedorCasoUso.addRepository(repository);
    }

    @Test
    void asignarVendedor() {

        //Arrange
        var command = new AsignarVendedor(
                TiendaId.of("CiberCan"),
                VendedorId.of("v003"),
                new Nombre("Milton"),
                new Telefono("3004368015"),
                new Email("milton@cibercanventas.com"),
                new FechaPago(25, 12, 2021)
        );
        var casoUso = new AsignarVendedorCasoUso();
        Mockito.when(repository.getEventsBy("CiberCan")).thenReturn(events());
        casoUso.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("CiberCan")
                .syncExecutor(casoUso, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var vendedorAsignado = (VendedorAsignado) events.get(0);
        Assertions.assertEquals("v003", vendedorAsignado.getVendedorId().value());
        Assertions.assertEquals("Milton", vendedorAsignado.getNombre().value());
        Assertions.assertEquals("3004368015", vendedorAsignado.getTelefono().value());
        Assertions.assertEquals("milton@cibercanventas.com", vendedorAsignado.getEmail().value());
        Assertions.assertEquals("25-12-2021", vendedorAsignado.getFechaPago().value());

    }

    private List<DomainEvent> events() {
        return List.of(new TiendaCreada(
                new Nombre("CiberCan")
        ));
    }

}