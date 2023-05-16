package com.hh.demoSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//controlador
@RestController
public class HelloWorldController {
    @GetMapping("/hello") //ruta
    public String sayHello() { return "Hello dev"; }
}
