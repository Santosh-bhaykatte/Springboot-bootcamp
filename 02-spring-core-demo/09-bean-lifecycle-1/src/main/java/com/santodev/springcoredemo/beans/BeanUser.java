package com.santodev.springcoredemo.beans;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BeanUser implements CommandLineRunner {
    private final MyBean myBean;

    //Dependency Injection (Happens during initialization phase)
    public BeanUser(MyBean myBean) {
        this.myBean = myBean;
        System.out.println("BeanUser: Dependency Injected (MyBean)");
    }

    @Override
    public void run(String... args) {
        System.out.println("Application started, running BeanUser");
        myBean.performTask();
    }
}
