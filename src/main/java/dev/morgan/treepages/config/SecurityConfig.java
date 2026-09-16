package dev.morgan.treepages.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // avisa para o springboot que esse arquivo é de configuração e deixa de usar o default
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean // Antigamente arquivo de convenção, agora é qualquer aplicaçãp que o spring controla
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/css/**",
                                "/assets/**",
                                "/templates/singup.html",
                                "/templates/login.html",
                                "/templates/welcome.html",
                                "/auth/register",
                                "/error",
                                "/js/**"

                        ).permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }

}
