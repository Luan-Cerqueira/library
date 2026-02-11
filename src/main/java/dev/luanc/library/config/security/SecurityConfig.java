package dev.luanc.library.config.security;

import jakarta.servlet.DispatcherType;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final SecurityFilter securityFilter;

    public SecurityConfig(SecurityFilter securityFilter){
        this.securityFilter = securityFilter;
    }

    public static final String [] ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED_POST = {
            "/api/v1/auth/**",
    };

    public static final String [] ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED_GET = {
            "/api/v1/genres/**",
            "/api/v1/publishers/**",
            "/api/v1/authors/**",
            "/api/v1/books/**",
            "/api/v1/copies/**"
    };
    public static final String [] ENDPOINTS_WITH_AUTHENTICATION_REQUIRED = {
            "/api/v1/users/me/**"
    };

    public static final String [] ENDPOINTS_ADMIN = {
            "/api/v1/books/**",
            "/api/v1/loans/**",
            "/api/v1/genres/**",
            "/api/v1/authors/**",
            "/api/v1/copies/**",
            "api/v1/publishers/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configure(http))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .dispatcherTypeMatchers(DispatcherType.ERROR).permitAll()
                        .requestMatchers(ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED_POST).permitAll()
                        .requestMatchers(HttpMethod.GET, ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED_GET).permitAll()
                        .requestMatchers(ENDPOINTS_ADMIN).hasRole("ADMIN")
                        .requestMatchers(ENDPOINTS_WITH_AUTHENTICATION_REQUIRED).authenticated()
                        .anyRequest().denyAll()
                ).addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
