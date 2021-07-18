package com.andy.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("demoBean")
@RequestMapping("v1/demo")
public class DemoController {
    
    @GetMapping("/message")
    public String sayHello() {
        return "Hello World! "; 
    }
}
