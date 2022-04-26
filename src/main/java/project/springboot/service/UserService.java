package project.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import project.springboot.dto.UserRegistration;
import project.springboot.model.User;

public interface UserService extends UserDetailsService {
    User save(UserRegistration registration);
}
