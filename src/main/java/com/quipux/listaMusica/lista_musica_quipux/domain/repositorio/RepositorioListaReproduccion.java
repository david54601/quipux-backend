package com.quipux.listaMusica.lista_musica_quipux.domain.repositorio;


import com.quipux.listaMusica.lista_musica_quipux.domain.core.ListaReproduccion;
import com.quipux.listaMusica.lista_musica_quipux.domain.dto.ListaReproduccionDto;


import java.util.List;
import java.util.Optional;

public interface RepositorioListaReproduccion {
    List<ListaReproduccionDto> obtenerListasReproduccion();
    Optional<ListaReproduccionDto> obtenerListaReproduccionPorNombre(String nombre);
    ListaReproduccionDto guardarListaReproduccion(ListaReproduccion listaReproduccion);
    void eliminarListaReproduccionPorId(Integer id);
}
