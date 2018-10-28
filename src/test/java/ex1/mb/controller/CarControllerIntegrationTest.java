package ex1.mb.controller;

import ex1.mb.entity.Car;
import ex1.mb.entity.Employee;
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

public class CarControllerIntegrationTest {
    private final static String ROOT = "http://localhost:8080/Car";
    private final static String ADD = "/add";
    private final static String GET_BY_ID = "/get";
    private static final String ALL = "/all";
    private static final String DELETE = "/delete";
    private static final String UPDATE = "/update";

    @Test
    public void addCar() {
        Car car = createdCar();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Car> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Car.class,
                car.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    public void checkGetAllCars() {
        createdCar();
        createdCar();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Car>> responseEntity = getListResponseEntity(restTemplate);
        List<Car> cars = responseEntity.getBody();

        for (Car car : cars) {
            assertNotNull(car);
        }
    }

    @Test
    public void deleteCar() {
        createdCar();
        Car car = createdCar();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Car>> responseEntity1 = getListResponseEntity(restTemplate);
        List<Car> cars1 = responseEntity1.getBody();
        ResponseEntity<Car> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                Car.class,
                car.getId()
        );
        ResponseEntity<List<Car>> responseEntity2 = getListResponseEntity(restTemplate);
        List<Car> cars2 = responseEntity2.getBody();

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        assertEquals(1, cars1.size() - cars2.size());
    }

    @Test
    public void updateCar() {
        Car car = createdCar();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Car carUpdate = prefillCar(car.getId());
        HttpEntity<Car> entity = new HttpEntity<>(carUpdate, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Car> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                entity,
                Car.class
        );
        Car updatedCar = responseEntity.getBody();

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        assertNotNull(updatedCar);
        assertEquals(car.getId(), updatedCar.getId());
    }

    private ResponseEntity<List<Car>> getListResponseEntity(RestTemplate restTemplate) {
        return restTemplate.exchange(
                ROOT + GET_BY_ID + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Car>>() {
                }
        );
    }

    private Car createdCar() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Car car = prefillCar();
        HttpEntity<Car> entity = new HttpEntity<>(car, headers);
        RestTemplate restTemplate = new RestTemplate();
        Car createdCar = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Car.class
        ).getBody();

        assertNotNull(createdCar);
        assertNotNull(createdCar.getName());
        return createdCar;
    }

    private Car prefillCar() {
        Car car = new Car();
        car.setName("Volvo");

        Employee ivanov=new Employee();
        Employee petrov=new Employee();

        ivanov.setName("Ivanov");
        petrov.setName("Petrov");

        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(ivanov);
        employeeList.add(petrov);
        car.setEmployeeList(employeeList);
        return car;
    }

    private Car prefillCar(long id) {
        Car car = new Car();
        car.setId(id);
        car.setName("Fiat");
        Employee sidorov=new Employee();
        Employee serov=new Employee();

        sidorov.setName("Sidorov");
        serov.setName("Serov");

        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(sidorov);
        employeeList.add(serov);
        car.setEmployeeList(employeeList);
        return car;
    }
}
