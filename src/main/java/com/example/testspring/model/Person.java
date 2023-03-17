package com.example.testspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.UUID;

public class Person {
    private final UUID id;//finale ne peut etre changé

    private final String name;

    public String getName() {
        return name;
    }

    public Person(@JsonProperty("id") UUID id,@JsonProperty("name") String name){
        this.id=id;
        this.name=name;
    }

    public UUID getId() {
        return id;
    }
}
