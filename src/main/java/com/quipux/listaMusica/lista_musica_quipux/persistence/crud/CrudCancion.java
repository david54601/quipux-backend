package com.quipux.listaMusica.lista_musica_quipux.persistence.crud;



import com.quipux.listaMusica.lista_musica_quipux.persistence.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudCancion extends CrudRepository<CancionEntity,Integer> {

    @Query(value = "" +
            "SELECT a.* FROM CANCIONES a, CANCIONES_EN_LISTA  b " +
            "WHERE  a.id = b.ID_CANCION  and" +
            "       b.ID_LISTA_REPRODUCCION = :listaId ",nativeQuery = true)
    List<CancionEntity> obtenerCancionesPorLista(Integer listaId);
}