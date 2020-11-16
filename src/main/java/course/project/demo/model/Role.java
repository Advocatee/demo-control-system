package course.project.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@Data
public class Role extends BaseEntity {

    @Column
    private String name;
    @OneToOne(mappedBy = "role" , cascade = CascadeType.ALL, orphanRemoval = true)
    private User user;

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                '}';
    }
}
