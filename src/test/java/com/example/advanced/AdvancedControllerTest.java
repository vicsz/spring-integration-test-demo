package com.example.advanced;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT)
public class AdvancedControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RestTemplate mockRestTemplate;

    private MockRestServiceServer server;

    @Before
    public void setup(){
        server = MockRestServiceServer.createServer(mockRestTemplate);
    }

    @Test
    public void sampleTest() {
        server.expect(requestTo("http://www.google.com"))
                .andExpect(method(GET))
                .andRespond(withSuccess().body("mock result"));

        ResponseEntity<String> result = restTemplate.getForEntity("/advanced", String.class);

        assert result.getBody().equals("mock result");
    }
}
