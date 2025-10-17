package com.santodev.springrest.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")            // handles HTTP requests
public class DemoRestController {

    // expose "/hello" endpoint
    @GetMapping("/hello")           // handles HTTP GET requests
    public String sayHello() {
        return "Hello World";
    }
}
