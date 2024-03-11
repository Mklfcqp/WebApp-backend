package com.webapp.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUserTest() {
        User user = User.builder()
                .email("testuser@example.com")
                .password("password")
                .role(Role.USER)
                .build();
        userRepository.save(user);
        assertNotNull(user.getId());
    }

    @Test
    public void findUserByEmailTest() {
        String email = "testuser@example.com"; // assuming there is a user with this email already in the database
        User user = userRepository.findByEmail(email);
        assertNotNull(user);
        assertEquals(email, user.getEmail());
        assertEquals(Role.USER, user.getRole());
    }

    @Test
    public void findUserByIdTest() {
        Long id = 1L; // assuming there is a user with this id already in the database
        User user = userRepository.findById(id).orElse(null);
        assertNotNull(user);
        assertEquals(id, user.getId());
        assertEquals("testuser@example.com", user.getEmail());
        assertEquals(Role.USER, user.getRole());
    }

    @Test
    public void updateUserTest() {
        String email = "testuser@example.com"; // assuming there is a user with this email already in the database
        User user = userRepository.findByEmail(email);
        assertNotNull(user);
        user.setPassword("newpassword");
        userRepository.save(user);
        User updatedUser = userRepository.findByEmail(email);
        assertNotNull(updatedUser);
        assertEquals("newpassword", updatedUser.getPassword());
    }

    @Test
    public void deleteUserTest() {
        Long id = 1L; // assuming there is a user with this id already in the database
        userRepository.deleteById(id);
        User user = userRepository.findById(id).orElse(null);
        assertNull(user);
    }

    @Test
    public void getUserWatchlistsTest() {
        String email = "testuser@example.com"; // assuming there is a user with this email already in the database
        User user = userRepository.findByEmail(email);
        assertNotNull(user);
        List<Watchlist> watchlists = user.getWatchlists();
        assertNotNull(watchlists);
        // add assertion here if needed
    }

    @Test
    public void getUserPortfoliosTest() {
        String email = "testuser@example.com"; // assuming there is a user with this email already in the database
        User user = userRepository.findByEmail(email);
        assertNotNull(user);
        List<Portfolio> portfolios = user.getPortfolios();
        assertNotNull(portfolios);
        // add assertion here if needed
    }

    @Test
    public void getAuthoritiesTest() {
        User user = User.builder()
                .email("testadmin@example.com")
                .password("password")
                .role(Role.ADMIN)
                .build();
        List<GrantedAuthority> authorities = user.getAuthorities();
        assertNotNull(authorities);
        assertEquals(2, authorities.size());
        assertTrue(authorities.contains(new SimpleGrantedAuthority("ROLE_USER")));
        assertTrue(authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN")));
    }

    @Test
    public void getPasswordTest() {
        User user = User.builder()
                .email("testuser@example.com")
                .password("password")
                .role(Role.USER)
                .build();
        assertEquals("password", user.getPassword());
    }

    @Test
    public void getUsernameTest() {
        User user = User.builder()
                .email("testuser@example.com")
                .password("password")
                .role(Role.USER)
                .build();
        assertEquals("testuser@example.com", user.getUsername());
    }

    @Test
    public void isAccountNonExpiredTest() {
        User user = User.builder()
                .email("testuser@example.com")
                .password("password")
                .role(Role.USER)
                .build();
        assertTrue(user.isAccountNonExpired());
    }

    @Test
    public void isAccountNonLockedTest() {
        User user = User.builder()
                .email("testuser@example.com")
                .password("password")
                .role(Role.USER)
                .build();
        assertTrue(user.isAccountNonLocked());
    }

    @Test
    public void isCredentialsNonExpiredTest() {
        User user = User.builder()
                .email("testuser@example.com")
                .password("password")
                .role(Role.USER)
                .build();
        assertTrue(user.isCredentialsNonExpired());
    }

    @Test
    public void isEnabledTest() {
        User user = User.builder()
                .email("testuser@example.com")
                .password("password")
                .role(Role.USER)
                .build();
        assertTrue(user.isEnabled());
    }

}