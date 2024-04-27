package com.baeldung.application.service;

import com.baeldung.application.entities.User;
import com.baeldung.application.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void updateEmailDomain(String domain) {

        userRepository.findAll().forEach(u -> _updateDomain(u,domain));
    }

    private void _updateDomain(User user, String domain) {
        int index = user.getEmail().indexOf("@");
        user.setEmail(user.getEmail().substring(0,index+1) + domain);
    }
}
