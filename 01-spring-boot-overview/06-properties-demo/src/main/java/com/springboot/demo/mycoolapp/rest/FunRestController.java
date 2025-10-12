package com.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //inject custom properties
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose new endpoint "/teaminfo"
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: "+ coachName +", Team: "+ teamName;
    }

    // expose '/' that return "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }

    //expose new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run hard 5k!";
    }
}
