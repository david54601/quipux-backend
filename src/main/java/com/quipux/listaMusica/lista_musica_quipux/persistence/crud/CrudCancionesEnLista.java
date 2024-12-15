package com.quipux.listaMusica.lista_musica_quipux.persistence.crud;

import com.quipux.listaMusica.lista_musica_quipux.persistence.entity.CancionesListaEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudCancionesEnLista extends CrudRepository<CancionesListaEntity, Long> {

    @Query(value = "" +
            "SELECT * FROM CANCIONES_EN_LISTA " +
            "WHERE ID_LISTA_REPRODUCCION = :idLista", nativeQuery = true)
    List<CancionesListaEntity> obtenerCancionesEnListaPorIdLista(Integer idLista);

    @Modifying
    @Query(value = "" +
            "DELETE FROM CANCIONES_EN_LISTA " +
            "WHERE ID_LISTA_REPRODUCCION = :idLista", nativeQuery = true)
    void eliminarCancionesEnListaPorIdLista(Integer idLista);

}