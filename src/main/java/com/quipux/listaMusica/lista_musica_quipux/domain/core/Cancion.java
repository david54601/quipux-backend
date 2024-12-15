package com.quipux.listaMusica.lista_musica_quipux.domain.core;

import lombok.Getter;



import static com.quipux.listaMusica.lista_musica_quipux.utils.validation.ValidacionDominio.*;

import com.quipux.listaMusica.lista_musica_quipux.domain.dto.CancionDto;

@Getter
public class Cancion {

    private Integer id;
    private String titulo;
    private String artista;
    private String album;
    private String anno;
    private String genero;

    private Cancion(CancionDto dto){
        this.id = dto.getId();
        this.titulo = dto.getTitulo();
        this.artista = dto.getArtista();
        this.album = dto.getAlbum();
        this.anno = dto.getAnno();
        this.genero = dto.getGenero();
    }

    public static Cancion of(CancionDto dto){
        campoObligatorio(dto.getTitulo(), obtenerMensaje("titulo"));
        campoObligatorio(dto.getArtista(), obtenerMensaje("Artista"));
        campoObligatorio(dto.getAlbum(), obtenerMensaje("album"));
        campoObligatorio(dto.getAnno(), obtenerMensaje("año"));
        campoObligatorio(dto.getGenero(), obtenerMensaje("genero"));
        return new Cancion(dto);
    }
}
