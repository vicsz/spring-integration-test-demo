package com.example.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {

    @Autowired
    private SimpleComponent simpleComponent;


    public String sampleCall(){
        return simpleComponent.getValue();
    }

}
