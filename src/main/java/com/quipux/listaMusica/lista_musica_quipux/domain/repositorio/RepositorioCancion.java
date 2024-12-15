package com.quipux.listaMusica.lista_musica_quipux.domain.repositorio;

import com.quipux.listaMusica.lista_musica_quipux.domain.core.Cancion;
import com.quipux.listaMusica.lista_musica_quipux.domain.dto.CancionDto;

import java.util.List;


public interface RepositorioCancion {
    List<CancionDto> obtenerCancionesPorIdLista(Integer idLista);
    List<CancionDto> guardarCanciones(List<Cancion> canciones);

    void eliminarCancionPorId(Integer id);
}
