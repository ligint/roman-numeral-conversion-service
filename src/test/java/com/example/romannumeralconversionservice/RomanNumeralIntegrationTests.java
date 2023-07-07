package com.example.romannumeralconversionservice;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RomanNumeralIntegrationTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    HttpHeaders headers = new HttpHeaders();

    private String createURLWithPort(String url) {
        return "http://localhost:" + port + url;
    }

    @Test
    public void TestGetRomanNumeralConversion() throws JSONException {
        int number = 10;
        String expectedRomanNumeral = "{\"input\":\"10\",\"output\":\"X\"}";

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/romannumeral?query=" + number), HttpMethod.GET, entity, String.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(expectedRomanNumeral, response.getBody());
    }

    @Test
    public void TestInvalidRequest() throws JSONException {
        double number = 10.5;

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/romannumeral?query=" + number), HttpMethod.GET, entity, String.class);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void TestOutOfRangeRequest() throws JSONException {
        int number = 5999;

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/romannumeral?query=" + number), HttpMethod.GET, entity, String.class);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }



}
