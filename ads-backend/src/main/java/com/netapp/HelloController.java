package com.netapp;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class HelloController {
    
	@RequestMapping(value = "hello", method = RequestMethod.POST)
    public String index(@RequestBody Object obj) {
        return "Greetings from Spring Boot!";
    }
    
}
