package com.quipux.listaMusica.lista_musica_quipux.domain.dto;

import lombok.Data;

@Data
public class CancionDto {

    private Integer id;
    private String titulo;
    private String artista;
    private String album;
    private String anno;
    private String genero;


}
