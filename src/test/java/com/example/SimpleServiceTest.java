package com.example;

import org.jboss.byteman.contrib.bmunit.BMRule;
import org.jboss.byteman.contrib.bmunit.WithByteman;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
@WithByteman
class SimpleServiceTest {

    @BeforeEach
    void setUp() {
        //org.junit.platform.engine.support.discovery.SelectorResolver s;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @BMRule(name = "handle file not found",
            targetClass = "File",
            targetMethod = "<init>(String)",
            action = "throw new RuntimeException( \"Ha ha Byteman fooled you again!\" )"
    )
    void create() {
        File file = new File("C:\\tutorials\\src\\main\\resources\\lwk.txt");
        System.out.println(file.length());
    }
}