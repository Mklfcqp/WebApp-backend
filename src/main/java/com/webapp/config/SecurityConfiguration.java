package com.webapp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static com.webapp.user.Permission.*;
import static com.webapp.user.Role.ADMIN;
import static com.webapp.user.Role.USER;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private static final String[] FREE_URL = {
            "/auth/register",
            "/auth/login",
            "/user/**"
            };
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll())
//                .authorizeHttpRequests(req ->
//                        req.requestMatchers(FREE_URL)
//                                .permitAll()
//                                .requestMatchers("/test/**").hasAnyRole(ADMIN.name(), USER.name())
//                                .requestMatchers(GET, "/test/**").hasAnyAuthority(ADMIN_READ.name(), USER_READ.name())
//                                .requestMatchers(POST, "/test/**").hasAnyAuthority(ADMIN_CREATE.name(), USER_CREATE.name())
//                                .requestMatchers(PUT, "/test/**").hasAnyAuthority(ADMIN_UPDATE.name(), USER_UPDATE.name())
//                                .requestMatchers(DELETE, "/test/**").hasAnyAuthority(ADMIN_DELETE.name(), USER_DELETE.name())
//                                .anyRequest()
//                                .authenticated()
//                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout ->
                        logout.logoutUrl("/auth/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                )
        ;

        return http.build();
    }
}
