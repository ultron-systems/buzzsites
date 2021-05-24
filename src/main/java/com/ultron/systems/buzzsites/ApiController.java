package com.ultron.systems.buzzsites;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping(value = "/")
    public String index() {
        return "Bonjour tout le monde!";
    }

    @GetMapping(value = "/contact")
    public String contact() {
        return "Page de contact";
    }
}
