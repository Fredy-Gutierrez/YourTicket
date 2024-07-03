package com.yourticket.configurations;

import com.yourticket.filters.JwtFilter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
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
                .addFilterBefore(jwtFilter, AnonymousAuthenticationFilter.class)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(
                            new AntPathRequestMatcher("/usersession/login"),
                            new AntPathRequestMatcher("/event/getall"),
                            new AntPathRequestMatcher("/event/get"),
                            new AntPathRequestMatcher("/event/getzones"),
                            new AntPathRequestMatcher("/event/getrows"),
                            new AntPathRequestMatcher("/event/getseats")
                            )
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/user/create"),
                                    new AntPathRequestMatcher("/user/createseller"))
                            .anonymous()
                            .requestMatchers(new AntPathRequestMatcher("/event/**"))
                            .hasAuthority("SELLER")
                            .anyRequest().authenticated()
                            ;
                })
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider);

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
