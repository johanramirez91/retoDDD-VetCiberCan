package com.example.cibercan.domain.adopcion.value;

import co.com.sofka.domain.generic.Identity;

public class AnimalAdopcionId extends Identity {

    public AnimalAdopcionId() {
    }

    public AnimalAdopcionId(String id) {
        super(id);
    }

    public static AnimalAdopcionId of(String id){
        return new AnimalAdopcionId(id);
    }
}
