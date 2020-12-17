package course.project.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor
public class Year extends BaseEntity {

    private int yearOfBuild;
    private int yearOfLastRenovation;
    @ManyToMany(mappedBy = "years")
    private Set<Flat> flats;
    @Override
    public String toString() {
        return "Year{" +
                "yearOfBuild=" + yearOfBuild +
                ", yearOfLastRenovation=" + yearOfLastRenovation +
                '}';
    }
}
