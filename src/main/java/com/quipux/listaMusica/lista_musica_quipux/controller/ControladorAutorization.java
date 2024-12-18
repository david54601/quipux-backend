package com.quipux.listaMusica.lista_musica_quipux.controller;



import com.quipux.listaMusica.lista_musica_quipux.config.JwtUtil;
import com.quipux.listaMusica.lista_musica_quipux.domain.dto.LoginDto;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class ControladorAutorization {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

   @PostMapping("/login")
public ResponseEntity<Map<String, String>> login(@RequestBody LoginDto loginDTO) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
    );

    String jwt = jwtUtil.create(loginDTO.getUsername());

    Map<String, String> response = new HashMap<>();
    response.put("token", jwt);

    return ResponseEntity.ok(response);
}

}
