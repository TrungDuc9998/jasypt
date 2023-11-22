package com.example.test_java.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeHttpRequests() // authorize http request
                .antMatchers("/api/v1/auth/**")
                .permitAll() // bất kì url đều ko cần xác thực
                .anyRequest() // bất kì url đều phải có quyền
                .authenticated()
                .and()
                .sessionManagement() // vô hiệu hóa theo phiên
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // dùng STATELESS vì là JWT
                .and()
                .authenticationProvider(authenticationProvider) // cung cấp authenticationProvider là DAO
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); // call username, password authen filter vì khi xác thực jwt chúng ta cần check hết


        return httpSecurity.build();
    }
}
