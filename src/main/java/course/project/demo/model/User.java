package course.project.demo.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String userName;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private boolean active ;
    @Column(nullable = false)
    private String password;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", active=" + active +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
