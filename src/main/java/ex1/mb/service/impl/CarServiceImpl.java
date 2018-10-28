package ex1.mb.service.impl;

import ex1.mb.dao.CarDao;
import ex1.mb.entity.Car;
import ex1.mb.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    public Car addCar(Car car) {
        return carDao.add(car);
    }

    @Override
    public Car getCarById(long id) {
        return carDao.getById(id);
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getAll();
    }

    @Override
    public Car updateCar(Car car) {
        return carDao.update(car);
    }

    @Override
    public Car deleteCar(long id) {
        return carDao.delete(getCarById(id));
    }
}
