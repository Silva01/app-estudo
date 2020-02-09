package com.estudo.estudo.config;

import com.estudo.estudo.security.EstudoDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class EstudoSecurityConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder,
                                PasswordEncoder passwordEncoder,
                                EstudoDetailsService estudoDetailsService) throws Exception {
        builder
                .userDetailsService(estudoDetailsService)
                .passwordEncoder(passwordEncoder);
    }
}
