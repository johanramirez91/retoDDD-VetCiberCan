package com.example.cibercan.domain.tienda.value;

import co.com.sofka.domain.generic.Identity;

public class AnimalClienteId extends Identity {

    public AnimalClienteId() {
    }

    public AnimalClienteId(String id){
        super(id);
    }

    public static AnimalClienteId of(String id){
        return new AnimalClienteId(id);
    }
}
