package com.example.cibercan.domain.adopcion.value;

import co.com.sofka.domain.generic.Identity;

public class AdopcionId extends Identity {

    public AdopcionId() {
    }

    public AdopcionId(String id) {
        super(id);
    }

    public static AdopcionId of(String id){
        return new AdopcionId(id);
    }
}
