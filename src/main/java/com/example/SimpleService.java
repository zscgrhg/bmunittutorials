package com.example;

import java.util.Date;

public class SimpleService {
    public void create(){
        SimpleEntity entity=new SimpleEntity();
        entity.setCreated(new Date());
        entity.setLabel("label");
    }
}
