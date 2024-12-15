package com.quipux.listaMusica.lista_musica_quipux.domain.dto;

import java.util.List;

import lombok.Data;

@Data
public class RespuestaListaReproduccionDto {
    private String nombre;
    private String descripcion;
    private List<CancionDto> canciones;
}
