package com.project.auth.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String[] PUBLIC_MATCHERS = {
            "/api/auth/login",
            "/api/auth/register",
            "/swagger-ui/**",
            "/v3/api-docs/**"
    };

   @Bean
          public SecurityFilterChain filterChain(HttpSecurity http, @Value("${app.static-token}") String staticToken)
                  throws Exception {
              String expectedToken = "Bearer " + staticToken;
              http
                      .csrf(csrf -> csrf.disable())
                      .authorizeHttpRequests(auth -> auth
                              .requestMatchers(PUBLIC_MATCHERS).permitAll()
                              .anyRequest().authenticated())
                      .addFilterBefore(new StaticTokenFilter(expectedToken), UsernamePasswordAuthenticationFilter.class);
              return http.build();
          }

    private static final class StaticTokenFilter extends OncePerRequestFilter {
        private final String expectedToken;

        private StaticTokenFilter(String expectedToken) {
            this.expectedToken = expectedToken;
        }

        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                        FilterChain filterChain) throws ServletException, IOException {
            String header = request.getHeader("Authorization");
            if (header == null || !header.equals(expectedToken)) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            filterChain.doFilter(request, response);
        }
    }
}
