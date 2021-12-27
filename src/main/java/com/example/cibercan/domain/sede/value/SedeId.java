package com.example.cibercan.domain.sede.value;

import co.com.sofka.domain.generic.Identity;

public class SedeId extends Identity {

    public SedeId() {
    }

    public SedeId(String id) {
        super(id);
    }

    public static SedeId of(String id) {
        return new SedeId(id);
    }
}
