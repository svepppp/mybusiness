package ex1.mb.dto;

import ex1.mb.entity.Car;
import ex1.mb.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDto {
    private Long id;
    private String name;
    private List<CarDto> carDtoList = new ArrayList<>();

    public List<EmployeeDto> getEmployeeDtoList(List<Employee> employeeList) {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();

        for (int i = 0; i < employeeList.size(); i++) {
            EmployeeDto employeeDto = getEmployeeDto(employeeList.get(i));

            employeeDtoList.add(employeeDto);
        }
        return employeeDtoList;
    }

    public EmployeeDto getEmployeeDto(Employee employee) {
        List<CarDto> carDtoList = new ArrayList<>();
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName((employee.getName()));

        getCarDtoFromCar(employee, carDtoList);
        employeeDto.setCarDtoList(carDtoList);
        return employeeDto;
    }

    private void getCarDtoFromCar(Employee employee, List<CarDto> carDtoList) {
        for (Car car : employee.getCarList()) {
            CarDto carDto = new CarDto();
            carDto.setId(car.getId());
            carDto.setName(car.getName());

            carDtoList.add(carDto);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CarDto> getCarDtoList() {
        return carDtoList;
    }

    public void setCarDtoList(List<CarDto> carDtoList) {
        this.carDtoList = carDtoList;
    }
}
