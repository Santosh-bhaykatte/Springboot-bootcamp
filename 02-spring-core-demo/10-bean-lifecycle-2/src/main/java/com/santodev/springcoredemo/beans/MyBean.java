package com.santodev.springcoredemo.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public abstract class MyBean {
    private final String name;

    //Constructor : Instantiation phase
    public MyBean(String name) {
        this.name = name;
        System.out.println("Constructor: "+ name +" instantiated");
    }

    //@PostConstruct: Initialization phase
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct: "+ name +" initialized");
    }

    //Custom method to define usage
    public void sayHello() {
        System.out.println(name +" says Hello!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("@PreDestroy: " + name + " destroyed");
    }
}
