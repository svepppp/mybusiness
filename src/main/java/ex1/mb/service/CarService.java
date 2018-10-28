package ex1.mb.service;

import ex1.mb.entity.Car;

import java.util.List;

public interface CarService {

    /**
     * method for add car
     *
     * @param car = car for adding
     * @return created car
     */
    Car addCar(Car car);

    /**
     * method for getting car by specific id
     *
     * @param id - car's id
     * @return car by id
     */
    Car getCarById(long id);

    /**
     * method for getting all cars
     *
     * @return all cars
     */
    List<Car> getAllCars();

    /**
     * method for update car
     *
     * @param car - car's with updated params
     * @return updated car
     */
    Car updateCar(Car car);

    /**
     * method for delete car by id
     *
     * @param id - car's id for delete
     * @return deleted car
     */
    Car deleteCar(long id);
}

