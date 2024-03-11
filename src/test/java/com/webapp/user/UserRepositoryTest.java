package com.webapp.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByEmailTest() {
        User user = User.builder()
                .email("testuser@example.com")
                .password("password")
                .role(Role.USER)
                .build();
        userRepository.save(user);
        Optional<User> foundUser = userRepository.findByEmail("testuser@example.com");
        assertTrue(foundUser.isPresent());
        assertEquals("testuser@example.com", foundUser.get().getEmail());
        assertEquals(Role.USER, foundUser.get().getRole());
    }
}