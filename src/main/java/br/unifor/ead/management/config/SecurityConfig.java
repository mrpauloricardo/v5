package br.unifor.ead.management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usando BCrypt para criptografia de senha
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  // Desabilitar CSRF para simplificar o uso de APIs REST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/register", "/login", "/public/**").permitAll()  // Permitir acesso público para registro e login
                        .anyRequest().authenticated()  // Todas as outras rotas requerem autenticação
                )
                .formLogin(form -> form
                        .loginPage("/login")  // Definir uma página personalizada de login
                        .defaultSuccessUrl("/subjects", true)  // Redirecionar para /subjects após login bem-sucedido
                        .usernameParameter("email")  // Usar o campo "email" no login ao invés de "username"
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")  // Redirecionar para a página de login após logout
                );
        return http.build();
    }
}

