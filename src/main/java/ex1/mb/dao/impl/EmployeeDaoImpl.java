package ex1.mb.dao.impl;

import ex1.mb.dao.EmployeeDao;
import ex1.mb.entity.Employee;

public class EmployeeDaoImpl extends BasicDaoImpl<Employee> implements EmployeeDao {
    public EmployeeDaoImpl(Class<Employee> entityClass) {
        super(entityClass);
    }
}