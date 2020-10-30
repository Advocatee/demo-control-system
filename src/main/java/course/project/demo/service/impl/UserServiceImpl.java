package course.project.demo.service.impl;

import course.project.demo.model.User;
import course.project.demo.repository.UserRepository;
import course.project.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Optional<User> findByUserName(String username) {
        Optional<User> result = userRepository.findByUserName(username);
        log.info("In findByUserName - user: {} found by username: {}", result, username);
        return result;
    }
}
