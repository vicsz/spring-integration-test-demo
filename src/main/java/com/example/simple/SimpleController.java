package com.example.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @Autowired
    private SimpleService simpleService;

    @RequestMapping("/simple")
    public String sampleEndpoint(){
        return simpleService.sampleCall();
    }
}
