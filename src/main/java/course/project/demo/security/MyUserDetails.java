package course.project.demo.security;

import course.project.demo.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;


public class MyUserDetails implements UserDetails {

    private String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;


    public MyUserDetails(Optional<User> user) {

        this.userName = user.get().getUserName();
        this.password = user.get().getPassword();
        this.active = true;
        this.authorities = new ArrayList<>();
        authorities.add((GrantedAuthority) () -> "ROLE_" + user.get().getRole().getName());
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
//    @Override
//    public String toString() {
//        return "MyUserDetails{" +
//                "authorities=" + authorities.get(0).getAuthority() +
//                '}';
//    }
}


