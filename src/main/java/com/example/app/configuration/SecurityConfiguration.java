package com.example.app.configuration;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Configuration class for the application security.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    // TODO: implement the admin functionality
    // TODO: implement the CSRF protection

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf()
            .disable();

        http.authorizeRequests()
            .antMatchers("/registration", "/error")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/home")
            .permitAll()
            .and()
            .logout()
            .invalidateHttpSession(true)
            .permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoderBean() {
        return new BCryptPasswordEncoder();
    }
}