package ex1.mb.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cats")
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cat_id")
    private long id;

    private String description;
    private String name;

    @Column(columnDefinition = "DATE")
    private LocalDate year;

    @Column(columnDefinition = "TIME")
    private LocalTime time;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch =FetchType.EAGER)
    private List<CatWoman> catWomenList = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public List<CatWoman> getCatWomenList() {
        return catWomenList;
    }

    public void setCatWomenList(List<CatWoman> catWomenList) {
        this.catWomenList = catWomenList;
    }
}
