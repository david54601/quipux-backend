package com.quipux.listaMusica.lista_musica_quipux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.quipux.listaMusica.lista_musica_quipux.controller",
    "com.quipux.listaMusica.lista_musica_quipux.service",
    "com.quipux.listaMusica.lista_musica_quipux.repository",
    "com.quipux.listaMusica.lista_musica_quipux.persistence.mapper", 
    "com.quipux.listaMusica.lista_musica_quipux",// Asegúrate de incluir este paquete
})
public class ListaMusicaQuipuxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListaMusicaQuipuxApplication.class, args);
	}

}
