package ex1.mb.service.impl;

import ex1.mb.dao.EmployeeDao;
import ex1.mb.dto.EmployeeDto;
import ex1.mb.entity.Employee;
import ex1.mb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private EmployeeDto employeeDto;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeDao.add(employee);
    }

    @Override
    public EmployeeDto getEmployeeDtoById(long id) {
        return employeeDto.getEmployeeDto(employeeDao.getById(id));
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeDto.getEmployeeDtoList(employeeDao.getAll());
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public EmployeeDto deleteEmployee(long id) {
        return  employeeDto.getEmployeeDto(employeeDao.delete(employeeDao.getById(id)));
    }
}
