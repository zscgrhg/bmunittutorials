package com.example;

import lombok.Data;

import java.util.Date;

@Data
public class SimpleEntity {
    private String name;
    private String label;
    private String number;
    private Date created;
}
