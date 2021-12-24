package com.example.cibercan.domain.sede.value;

import co.com.sofka.domain.generic.Identity;

public class VeterinarioId extends Identity {

    public VeterinarioId() {
    }

    public VeterinarioId(String id) {
        super(id);
    }

    public static VeterinarioId of(String id){
        return new VeterinarioId(id);
    }
}
