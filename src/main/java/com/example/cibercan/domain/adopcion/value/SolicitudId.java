package com.example.cibercan.domain.adopcion.value;

import co.com.sofka.domain.generic.Identity;

public class SolicitudId extends Identity {

    public SolicitudId() {
    }

    public SolicitudId(String id) {
        super(id);
    }

    public static SolicitudId of(String id){
        return new SolicitudId(id);
    }
}
