package com.quipux.listaMusica.lista_musica_quipux.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
@RequiredArgsConstructor
public class ConfiguracionSeguridad {
        public static final String ADMIN = "ADMIN";
        public static final String USER = "USER";
    
        private final FiltroJwt filtroJwt;
    
        @Bean
        public SecurityFilterChain configure(HttpSecurity http, Cors configuracionCors) throws Exception {
            http
                    .csrf(AbstractHttpConfigurer::disable)
                    .cors(cors -> cors.configurationSource(configuracionCors.corsConfigurationSource()))
                    .sessionManagement(httpSecuritySessionManagementConfigurer ->
                            httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authorizeHttpRequests(requests -> requests
                            .requestMatchers("/api/auth/**").permitAll()
                            .requestMatchers(HttpMethod.GET, "/listas/**").hasAnyRole(ADMIN, USER)
                            .requestMatchers(HttpMethod.POST, "/listas").hasRole(ADMIN)
                            .requestMatchers(HttpMethod.DELETE, "/listas/**").hasRole(ADMIN)
                            .anyRequest()
                            .authenticated())
                    .addFilterBefore(filtroJwt, UsernamePasswordAuthenticationFilter.class);
            return http.build();
        }

}
