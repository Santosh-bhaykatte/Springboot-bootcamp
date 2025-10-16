package com.santodev.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }

    //define our init method
    @PostConstruct
    public void init() {
        System.out.println("Bean: 'CricketCoach' Initialized");
    }

    //define our destroy method
    @PreDestroy
    public void destroy() {
        System.out.println("Bean: 'CricketCoach' Destroyed");
    }

    @Override
    public String getDailyWorkout() {
        return "practice fast bowling for 15 minutes";
    }
}
