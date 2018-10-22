package ex1.mb.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name="cats")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cat_id")
    private long id;

    private String description;
    private String name;

    @Column(columnDefinition="DATE")
    private LocalDate year;

    @Column(columnDefinition="TIME")
    private LocalTime time;

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getYear() {
        return year;
    }

    public LocalTime getTime() {
        return time;
    }


}
