package com.quipux.listaMusica.lista_musica_quipux.persistence.crud;



import com.quipux.listaMusica.lista_musica_quipux.persistence.entity.ListaReproduccionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CrudListaReproduccion extends CrudRepository<ListaReproduccionEntity,Integer> {
    Optional<ListaReproduccionEntity> findByNombre(String nombre);
}
