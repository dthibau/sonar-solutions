package com.baeldung.application.service;

import com.baeldung.application.entities.User;
import com.baeldung.application.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    void updateDomainTest() {
        // Suppose we have Users in database

        userService.updateEmailDomain("formation.org");

        entityManager.flush();
        entityManager.clear();

        List<User> users = userRepository.findAll();

        assertThat(users).extracting("email").contains("john@formation.org");
    }
}
