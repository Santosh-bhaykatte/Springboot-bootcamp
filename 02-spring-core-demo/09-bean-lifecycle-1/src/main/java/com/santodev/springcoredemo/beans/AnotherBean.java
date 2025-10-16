package com.santodev.springcoredemo.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component("anotherBean")
public class AnotherBean {

    //Constructor -> Instantiation phase
    public AnotherBean() {
        System.out.println("Constructor: AnotherBean Instantiated");
    }

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct: AnotherBean Initialized (Dependencies Injected)");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("@PreDestroy: AnotherBean Destroyed before shutdown");
    }
}
