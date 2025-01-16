package com.indium.lab03restapi.entity;

import lombok.Data;

public class Product {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
