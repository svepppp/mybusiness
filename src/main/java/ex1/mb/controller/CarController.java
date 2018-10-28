package ex1.mb.controller;

import ex1.mb.entity.Car;
import ex1.mb.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/Car")
public class CarController {


    @Autowired
    private CarService carService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "appliCarion/json;charset=utf-8")
    public Car addCar(@RequestBody Car car){    //кастим к Car
        carService.addCar(car);
        return car;
    }

    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "appliCarion/json;charset=utf-8")
    public Car getCarById(@PathVariable(value = "id") long id){
        return carService.getCarById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "appliCarion/json;charset=utf-8")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "appliCarion/json;charset=utf-8")
    public Car updateCar(@RequestBody Car car){
        return carService.updateCar(car);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "appliCarion/json;charset=utf-8")
    public Car deleteCar(@PathVariable(value = "id") long id){
        return carService.deleteCar(id);
    }
}
