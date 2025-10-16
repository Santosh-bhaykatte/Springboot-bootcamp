package com.santodev.springcoredemo.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean extends MyBean {
    public PrototypeBean() {
        super("PrototypeBean");
    }
}
