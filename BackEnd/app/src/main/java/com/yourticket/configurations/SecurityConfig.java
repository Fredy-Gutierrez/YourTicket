/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yourticket.configurations;

import com.yourticket.filters.JwtFilter;
import com.yourticket.repositories.IUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 *
 * @author fredd
 */
@Configuration
public class SecurityConfig {
    
    @Autowired
    private JwtFilter jwtFilter;
    
    @Autowired
    private AppConfig appConfig;
    
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .cors(cors -> cors.configurationSource(corsConfigurationSource()))
        .csrf(csrf -> csrf.disable())
        //.addFilterBefore(new JwtFilter(), AnonymousAuthenticationFilter.class)
        .addFilterBefore(jwtFilter, AnonymousAuthenticationFilter.class)
        .authorizeHttpRequests(auth -> {
//            auth
//            .requestMatchers(HttpMethod.POST,
//                    "/api/yourticket/**",
//                    "/api/yourticket/usersession/login", 
//                    "/api/yourticket/user/create", 
//                    "/api/yourticket/user/createseller")
//            .permitAll();
            auth.requestMatchers(
                    new AntPathRequestMatcher("/**"),
                    new AntPathRequestMatcher("/usersession/login")
            ).permitAll()
            .requestMatchers(new AntPathRequestMatcher("/user/create"),
                    new AntPathRequestMatcher("/user/createseller")
            ).anonymous();
        })
        /*.authorizeHttpRequests(auth -> {
                auth
                .requestMatchers("/api/yourticket/usersession/logout").hasAnyAuthority("ADMIN", "USER", "SELLER")
                .anyRequest().authenticated();
        })*/
        .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authenticationProvider(authenticationProvider);
        //.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        String regex = "\\s*,\\s*";

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of(appConfig.getAllowedOrigins().split(regex)));
        configuration.setAllowedMethods(List.of(appConfig.getAllowedMethods().split(regex)));
        configuration.setAllowedHeaders(List.of(appConfig.getAllowedHeaders().split(regex)));
        configuration.setExposedHeaders(List.of(appConfig.getExposedHeaders().split(regex)));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
