package ex1.mb.controller;

import ex1.mb.entity.Cat;
import ex1.mb.entity.CatWoman;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CatControllerIntegrationTest {

    private final static String ROOT = "http://localhost:8080/cat";
    private final static String ADD = "/add";
    private final static String GET_BY_ID = "/get";
    private static final String ALL = "/all";
    private static final String DELETE = "/delete";
    private static final String UPDATE = "/update";

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

    @Test
    public void checkGetAllCats() {
        createdCat();
        createdCat();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Cat>> responseEntity = getListResponseEntity(restTemplate);
        List<Cat> cats = responseEntity.getBody();

        for (Cat cat : cats) {
            assertNotNull(cat);
        }
      }

    @Test
    public void deleteCat() {
        createdCat();
        Cat cat = createdCat();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Cat>> responseEntity1 = getListResponseEntity(restTemplate);
        List<Cat> cats1 = responseEntity1.getBody();
        ResponseEntity<Cat> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                Cat.class,
                cat.getId()
        );
        ResponseEntity<List<Cat>> responseEntity2 = getListResponseEntity(restTemplate);
        List<Cat> cats2 = responseEntity2.getBody();

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        assertEquals(1, cats1.size() - cats2.size());
    }

    @Test
    public void updateCat() {
        Cat cat = createdCat();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Cat catUpdate = prefillCat(cat.getId());
        HttpEntity<Cat> entity = new HttpEntity<>(catUpdate, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Cat> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                entity,
                Cat.class
        );
        Cat updatedCat = responseEntity.getBody();

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        assertNotNull(updatedCat);
        assertEquals(cat.getId(), updatedCat.getId());
    }

    private ResponseEntity<List<Cat>> getListResponseEntity(RestTemplate restTemplate) {
        return restTemplate.exchange(
                ROOT + GET_BY_ID + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Cat>>() {
                }
        );
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

        CatWoman liska=new CatWoman();
        CatWoman riska=new CatWoman();

        liska.setName("Liska");
        riska.setName("Riska");
        liska.setDescription("funny");
        riska.setDescription("happy");

        List<CatWoman> catWomenList=new ArrayList<>();
        catWomenList.add(liska);
        catWomenList.add(riska);
        cat.setCatWomenList(catWomenList);
        return cat;
    }

    private Cat prefillCat(long id) {
        Cat cat = new Cat();
        cat.setId(id);
        cat.setName("Marsik");
        cat.setDescription("happy");
        cat.setTime(LocalTime.of(11, 12, 35));
        cat.setYear(LocalDate.of(2013, 3, 5));

        CatWoman liska=new CatWoman();
        CatWoman riska=new CatWoman();

        liska.setName("Liska");
        riska.setName("Riska");
        liska.setDescription("funny");
        riska.setDescription("happy");

        List<CatWoman> catWomenList=new ArrayList<>();
        catWomenList.add(liska);
        catWomenList.add(riska);
        cat.setCatWomenList(catWomenList);
        return cat;
    }
}
