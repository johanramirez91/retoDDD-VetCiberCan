package com.example.cibercan.domain.tienda;

import co.com.sofka.domain.generic.Entity;
import com.example.cibercan.domain.tienda.value.ClienteId;
import com.example.cibercan.domain.tienda.value.Descuento;
import com.example.cibercan.domain.tienda.value.PagoDinero;
import com.example.cibercan.genericvalues.Email;
import com.example.cibercan.genericvalues.Nombre;
import com.example.cibercan.genericvalues.Telefono;

import java.util.Objects;

public class Cliente extends Entity<ClienteId> {

    private Nombre nombre;
    private PagoDinero pagoDinero;
    private Descuento descuento;
    private Telefono telefono;
    private Email email;

    public Cliente(ClienteId clienteId, Nombre nombre, PagoDinero pagoDinero, Descuento descuento, Telefono telefono, Email email) {
        super(clienteId);
        this.nombre = Objects.requireNonNull(nombre);
        this.pagoDinero = Objects.requireNonNull(pagoDinero);
        this.descuento = Objects.requireNonNull(descuento);
        this.telefono = Objects.requireNonNull(telefono);
        this.email = Objects.requireNonNull(email);
    }

    public void asignarDescuento(Descuento descuento, ClienteId clienteId){
        this.descuento = descuento;
    }

    public void actualizarDatosCliente(ClienteId clienteId, Nombre nombre, PagoDinero pagoDinero, Descuento descuento, Telefono telefono, Email email){
        this.entityId = Objects.requireNonNull(clienteId, "El id no puede ser nulo");
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.pagoDinero = Objects.requireNonNull(pagoDinero, "El pago no puede ser nulo");
        this.descuento = Objects.requireNonNull(descuento, "El descuento no puede ser nulo");
        this.telefono = Objects.requireNonNull(telefono, "El telefono no puede ser nulo");
        this.email = Objects.requireNonNull(email, "El email no puede ser nulo");
    }

    public Nombre Nombre() {
        return nombre;
    }

    public PagoDinero PagoDinero() {
        return pagoDinero;
    }

    public Descuento Descuento() {
        return descuento;
    }

    public Telefono Telefono() {
        return telefono;
    }

    public Email Email() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre) && Objects.equals(pagoDinero, cliente.pagoDinero) && Objects.equals(descuento, cliente.descuento) && Objects.equals(telefono, cliente.telefono) && Objects.equals(email, cliente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nombre, pagoDinero, descuento, telefono, email);
    }
}
