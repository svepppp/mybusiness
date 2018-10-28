package ex1.mb.service.impl;

import ex1.mb.dao.EmployeeDao;
import ex1.mb.entity.Employee;
import ex1.mb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeDao.add(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeDao.getById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public Employee deleteEmployee(long id) {
        return employeeDao.delete(getEmployeeById(id));
    }
}
