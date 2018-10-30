package ex1.mb.controller;

import ex1.mb.entity.Car;
import ex1.mb.entity.Employee;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EmployeeControllerIntegrationTest {
    private final static String ROOT = "http://localhost:8080/Employee";
    private final static String ADD = "/add";
    private final static String GET_BY_ID = "/get";
    private static final String ALL = "/all";
    private static final String DELETE = "/delete";
    private static final String UPDATE = "/update";

    @Test
    public void addEmployee() {
        Employee employee = createdEmployee();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Employee.class,
                employee.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    public void checkGetAllEmployees() {
        createdEmployee();
        createdEmployee();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Employee>> responseEntity = getListResponseEntity(restTemplate);
        List<Employee> employees = responseEntity.getBody();

        for (Employee employee : employees) {
            assertNotNull(employee);
        }
    }

    @Test
    public void deleteEmployee() {
        createdEmployee();
        Employee employee = createdEmployee();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Employee>> responseEntity1 = getListResponseEntity(restTemplate);
        List<Employee> employees1 = responseEntity1.getBody();
        ResponseEntity<Employee> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                Employee.class,
                employee.getId()
        );
        ResponseEntity<List<Employee>> responseEntity2 = getListResponseEntity(restTemplate);
        List<Employee> employees2 = responseEntity2.getBody();

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        assertEquals(1, employees1.size() - employees2.size());
    }


    @Test
    public void updateEmployee() {
        Employee employee = createdEmployee();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Employee employeeUpdate = prefillEmployee(employee.getId());
        HttpEntity<Employee> entity = new HttpEntity<>(employeeUpdate, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                entity,
                Employee.class
        );
        Employee updatedEmployee = responseEntity.getBody();

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        assertNotNull(updatedEmployee);
        assertEquals(employee.getId(), updatedEmployee.getId());
    }


    private ResponseEntity<List<Employee>> getListResponseEntity(RestTemplate restTemplate) {
        return restTemplate.exchange(
                ROOT + GET_BY_ID + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {
                }
        );
    }

    private Employee createdEmployee() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Employee employee = prefillEmployee();
        HttpEntity<Employee> entity = new HttpEntity<>(employee, headers);
        RestTemplate restTemplate = new RestTemplate();
        Employee createdEmployee = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Employee.class
        ).getBody();

        assertNotNull(createdEmployee);
        assertNotNull(createdEmployee.getName());
        return createdEmployee;
    }

    private Employee prefillEmployee() {
        Employee employee = new Employee();
        employee.setName("Ivanov");

        Car volvo = new Car();
        Car fiat = new Car();
        volvo.setName("Volvo");
        fiat.setName("Fiat");

        List<Car> carList = new ArrayList<>();
        carList.add(volvo);
        carList.add(fiat);
        employee.setCarList(carList);
        return employee;
    }

    private Employee prefillEmployee(long id) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName("Petrov");

        Car volvo = new Car();
        volvo.setName("Volvo");
        Car fiat = new Car();
        fiat.setName("Fiat");

        List<Car> carList = new ArrayList<>();
        carList.add(volvo);
        carList.add(fiat);
        employee.setCarList(carList);
        return employee;
    }

   /* private List<Employee> prefillEmployeeList1() {
        Employee ivanov = new Employee();
        Employee petrov = new Employee();

        ivanov.setName("Ivanov");
        ivanov.setCarList(prefillCarList1());
        petrov.setName("Petrov");
        petrov.setCarList(prefillCarList1());
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(ivanov);
        employeeList.add(petrov);
        return employeeList;

    }

    private List<Car> prefillCarList1() {
        Car volvo = new Car();
        Car fiat = new Car();

        volvo.setName("Volvo");
        fiat.setName("Fiat");
   *//*volvo.setEmployeeList(prefillEmployeeList1());
        fiat.setEmployeeList(prefillEmployeeList1());*//*
        List<Car> carList = new ArrayList<>();
        carList.add(volvo);
        carList.add(fiat);
        return carList;
    }*/
}