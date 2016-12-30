package com.example.advanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class AdvancedService {

    @Autowired
    private RestTemplate restTemplate;

    public String sampleCall() {
        try {
            return restTemplate.getForEntity(new URI("http://www.google.com"), String.class).getBody();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
