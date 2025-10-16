package com.santodev.springcoredemo.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("singletonBean")
@Scope("singleton")
public class SingletonBean extends MyBean {
    public SingletonBean() {
        super("SingletonBean");
    }
}
