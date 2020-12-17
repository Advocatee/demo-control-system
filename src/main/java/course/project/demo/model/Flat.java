package course.project.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flat extends BaseEntity {

    public Flat(String street) {
        this.street = street;
    }

    private int countOfRoom;
    private int flour;
    private double priceInMonth;
    private double square;
    private String street;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Flat_Year",
            joinColumns = {@JoinColumn(name = "Flat_ID")},
            inverseJoinColumns = {@JoinColumn(name = "Year_ID")})
    private List<Year> years = new ArrayList<>();

    @Override
    public String toString() {
        return "Flat{" +
                "countOfRoom=" + countOfRoom +
                ", flour=" + flour +
                ", priceInMonth=" + priceInMonth +
                ", square=" + square +
                ", street='" + street + '\'' +
                '}';
    }

    @OneToMany(mappedBy = "flat", fetch = FetchType.EAGER)
    private List<Orders> order;

}
