package com.santodev.springcoredemo.config;

import com.santodev.springcoredemo.common.Coach;
import com.santodev.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
