package ex1.mb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    private List<Car> carList=new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
