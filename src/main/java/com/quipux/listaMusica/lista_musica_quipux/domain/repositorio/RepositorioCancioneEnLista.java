package com.quipux.listaMusica.lista_musica_quipux.domain.repositorio;

import com.quipux.listaMusica.lista_musica_quipux.domain.dto.CancionEnListaDto;

import java.util.List;

public interface RepositorioCancioneEnLista {
    void guardarListaYCanciones(List<CancionEnListaDto> cancionesEnLista);
    List<CancionEnListaDto> obtenerCancionEnLista(Integer id);
    void eliminarListaConIdLista(Integer idLista);

}
