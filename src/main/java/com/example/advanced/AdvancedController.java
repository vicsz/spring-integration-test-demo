package com.example.advanced;


import com.example.simple.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdvancedController {

    @Autowired
    private AdvancedService advancedService;

    @RequestMapping("/advanced")
    public String sampleEndpoint(){
        return advancedService.sampleCall();
    }
}