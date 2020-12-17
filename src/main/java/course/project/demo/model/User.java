package course.project.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class User extends BaseEntity {

    @Column(nullable = false, unique = false)
    private String userName;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String password;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLES", joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "id")}
            , inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "id")})
    private List<Role> roles;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Orders> orders = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
