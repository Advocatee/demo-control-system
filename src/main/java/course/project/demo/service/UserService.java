package course.project.demo.service;

import course.project.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    Optional<User> findByUserName(String username);


}
