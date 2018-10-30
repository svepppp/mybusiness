package ex1.mb.controller;

import ex1.mb.entity.Employee;
import ex1.mb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Employee addEmployee(@RequestBody Employee employee) {    //кастим к Employee
        employeeService.addEmployee(employee);
        return employee;
    }

    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public Employee getEmployeeById(@PathVariable(value = "id") long id) {
        return employeeService.getEmployeeById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    public Employee deleteEmployee(@PathVariable(value = "id") long id) {
        return employeeService.deleteEmployee(id);
    }
}
