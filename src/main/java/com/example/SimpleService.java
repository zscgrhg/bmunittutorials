package com.example;

import java.util.Date;

public class SimpleService {
    public SimpleEntity create(){
        SimpleEntity entity=SimpleEntityBuilder.newInstance();
        entity.setName("init name");
        entity.setCreated(new Date());
        entity.setLabel("label");
        return entity;
    }
}
