package com.demo.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello() {
        logger.debug("-------------HelloController: ");

        return "Hello World Spring Boot";
    }

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
}
