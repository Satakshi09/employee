package com.employee.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")

public class DockerController {
    @GetMapping
    public String sayHello() {
        return "Hello, Docker";
    }
}
