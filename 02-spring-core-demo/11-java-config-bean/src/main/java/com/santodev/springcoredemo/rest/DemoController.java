package com.santodev.springcoredemo.rest;

import com.santodev.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //private fields for dependency
    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("aquatic") Coach myCoach) {
        this.myCoach = myCoach;
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
