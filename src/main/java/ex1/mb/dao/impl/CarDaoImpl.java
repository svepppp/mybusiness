package ex1.mb.dao.impl;

import ex1.mb.dao.CarDao;
import ex1.mb.entity.Car;

public class CarDaoImpl extends BasicDaoImpl<Car> implements CarDao {
    public CarDaoImpl(Class<Car> entityClass) {
        super(entityClass);
    }
}