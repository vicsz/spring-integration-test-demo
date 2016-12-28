package com.example.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT)
public class SimpleControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private SimpleComponent simpleComponent;

    @Test
    public void sampleTest() {
        when(simpleComponent.getValue()).thenReturn("the mock!");

        ResponseEntity<String> result = restTemplate.getForEntity("/simple", String.class);

        assert result.getBody().equals("the mock!");
        assert result.getStatusCode().equals(HttpStatus.OK);

    }
}