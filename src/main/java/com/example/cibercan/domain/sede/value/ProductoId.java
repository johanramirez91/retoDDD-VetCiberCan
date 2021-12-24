package com.example.cibercan.domain.sede.value;

import co.com.sofka.domain.generic.Identity;

public class ProductoId extends Identity {

    public ProductoId() {
    }

    public ProductoId(String id) {
        super(id);
    }

    public static ProductoId of(String id){
        return new ProductoId(id);
    }
}
