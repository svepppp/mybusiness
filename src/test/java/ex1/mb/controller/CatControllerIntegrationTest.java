package ex1.mb.controller;

import ex1.mb.entity.Cat;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CatControllerIntegrationTest {

    private final static String ROOT = "http://localhost:8080/cat";
    private final static String ADD = "/add";
    private final static String GET_BY_ID = "/get";

    @Test
    public void addCat() {
        Cat cat = createdCat();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Cat> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Cat.class,
                cat.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        assertNotNull(responseEntity.getBody());
    }

    private Cat createdCat() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Cat cat = prefillCat();
        HttpEntity<Cat> entity = new HttpEntity<>(cat, headers);
        RestTemplate restTemplate = new RestTemplate();
        Cat createdCat = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Cat.class
        ).getBody();

        assertNotNull(createdCat);
        assertNotNull(createdCat.getName());
        return createdCat;
    }

    private Cat prefillCat() {
        Cat cat = new Cat();
        cat.setName("Barsik");
        cat.setDescription("funny");
        cat.setTime(LocalTime.of(10, 11, 34));
        cat.setYear(LocalDate.of(2012, 11, 12));
        return cat;
    }
}
