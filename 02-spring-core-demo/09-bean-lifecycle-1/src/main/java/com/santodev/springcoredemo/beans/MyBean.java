package com.santodev.springcoredemo.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {
    private final AnotherBean anotherBean;

    //Constructor -> Instantiation phase
    public MyBean(AnotherBean anotherBean) {
        this.anotherBean = anotherBean;
        System.out.println("Constructor: MyBean Instantiated");
    }

    //@PostConstruct -> Initialization phase
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct: MyBean Initialized (Dependencies injected)");
    }

    //Custom method to simulate usage
    public void performTask() {
        System.out.println("MyBean is now in use (Ready phase)");
    }

    //@PreDestroy -> Destruction phase
    @PreDestroy
    public void cleanup() {
        System.out.println("@PreDestroyed: MyBean destroyed before AnotherBean");
    }
}
