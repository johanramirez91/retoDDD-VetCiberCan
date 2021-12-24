package com.example.cibercan.domain.sede;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.cibercan.domain.sede.event.*;
import com.example.cibercan.domain.sede.value.*;
import com.example.cibercan.domain.tienda.value.TiendaId;
import com.example.cibercan.genericvalues.Descripcion;
import com.example.cibercan.genericvalues.Email;
import com.example.cibercan.genericvalues.Nombre;
import com.example.cibercan.genericvalues.Telefono;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Sede extends AggregateEvent<SedeId> {

    protected Nombre nombre;
    protected Direccion direccion;
    protected Telefono telefono;
    protected Set<Producto> productos;
    protected Set<Servicio> servicios;
    protected Set<Veterinario> veterinarios;
    protected TiendaId tiendaId;


    public Sede(SedeId sedeId, Nombre nombre, Telefono telefono, Direccion direccion) {
        super(sedeId);
        appendChange(new SedeCreada(nombre, telefono, direccion)).apply();
    }

    private Sede(SedeId sedeId){
        super(sedeId);
        subscribe(new SedeChange(this));
    }

    public static Sede from(SedeId sedeId, List<DomainEvent> events){
        var sede = new Sede(sedeId);
        events.forEach(sede::applyEvent);
        return sede;
    }

    public void asignarTienda(TiendaId tiendaId){
        appendChange(new TiendaAsignada(tiendaId)).apply();
    }

    public void asignarVeterinario(VeterinarioId veterinarioId, Nombre nombre, Email email, Telefono telefono){
        Objects.requireNonNull(veterinarioId, "El Id no puede ser nulo");
        Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        Objects.requireNonNull(email, "El email no puede ser nulo");
        Objects.requireNonNull(telefono, "El telefono no puede ser nulo");
        appendChange(new VeterinarioAsignado(veterinarioId, nombre, email, telefono)).apply();
    }

    public void agregarServicio(ServicioId servicioId, Descripcion descripcion){
        Objects.requireNonNull(servicioId, "El Id no puede ser nulo");
        Objects.requireNonNull(descripcion, "La descripcion no puede ser nula");
        appendChange(new ServicioAgregado(servicioId, descripcion)).apply();
    }

    public void actualizarDatosServicio(ServicioId servicioId, Descripcion descripcion){
        Objects.requireNonNull(servicioId, "El Id no puede ser nulo");
        Objects.requireNonNull(descripcion, "La descripcion no puede ser nula");
        appendChange(new DatosServicioActualizados(servicioId, descripcion)).apply();
    }

    public void agregarProducto(ProductoId productoId, Nombre nombre, Precio precio, Cantidad cantidad){
        Objects.requireNonNull(productoId, "El Id no puede ser nulo");
        Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        Objects.requireNonNull(precio, "El precio no puede ser nulo");
        Objects.requireNonNull(cantidad, "La cantidad no puede ser nula");
        appendChange(new ProductoAgregado(productoId, nombre, cantidad, precio)).apply();
    }

    public void actualizarDatosProducto(ProductoId productoId, Nombre nombre, Precio precio, Cantidad cantidad){
        Objects.requireNonNull(productoId, "El Id no puede ser nulo");
        Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        Objects.requireNonNull(precio, "El precio no puede ser nulo");
        Objects.requireNonNull(cantidad, "La cantidad no puede ser nula");
        appendChange(new DatosProductoActualizados(productoId, nombre, cantidad, precio)).apply();
    }

    public Optional<Veterinario> obtenerVeterinariosPorId(VeterinarioId veterinarioId){
        return Veterinarios().stream()
                .filter(veterinario -> veterinario.identity().equals(veterinarioId))
                .findFirst();
    }

    public Optional<Servicio> obtenerServiciosPorId(ServicioId servicioId){
        return Servicios().stream()
                .filter(servicio -> servicio.identity().equals(servicioId))
                .findFirst();
    }

    public Optional<Producto> obtenerProductosPorId(ProductoId productoId){
        return Productos().stream()
                .filter(producto -> producto.identity().equals(productoId))
                .findFirst();
    }

    public Nombre Nombre() {
        return nombre;
    }

    public Direccion Direccion() {
        return direccion;
    }

    public Telefono Telefono() {
        return telefono;
    }

    public Set<Producto> Productos() {
        return productos;
    }

    public Set<Servicio> Servicios() {
        return servicios;
    }

    public Set<Veterinario> Veterinarios() {
        return veterinarios;
    }

    public TiendaId TiendaId() {
        return tiendaId;
    }
}
