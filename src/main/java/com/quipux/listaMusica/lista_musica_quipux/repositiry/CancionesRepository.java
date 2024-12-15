package com.quipux.listaMusica.lista_musica_quipux.repositiry;



import com.quipux.listaMusica.lista_musica_quipux.domain.dto.CancionEnListaDto;
import com.quipux.listaMusica.lista_musica_quipux.domain.repositorio.RepositorioCancioneEnLista;
import com.quipux.listaMusica.lista_musica_quipux.persistence.crud.CrudCancionesEnLista;


import com.quipux.listaMusica.lista_musica_quipux.persistence.mapper.MapeadorCancionEnLista;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CancionesRepository implements RepositorioCancioneEnLista {

    private final CrudCancionesEnLista crudCancionesEnLista;
    private final MapeadorCancionEnLista mapeador;

    public CancionesRepository(CrudCancionesEnLista crudCancionesEnLista, MapeadorCancionEnLista mapeador) {
        this.crudCancionesEnLista = crudCancionesEnLista;
        this.mapeador = mapeador;
    }


    @Override
    public void guardarListaYCanciones(List<CancionEnListaDto> cancionEnLista) {
        crudCancionesEnLista.saveAll(mapeador.convertirAListaDeCancioneEntity(cancionEnLista));
    }

    @Override
    public List<CancionEnListaDto> obtenerCancionEnLista(Integer id) {
        return mapeador.convertirAListDeCancionesDto(crudCancionesEnLista.obtenerCancionesEnListaPorIdLista(id));
    }

    @Override
    public void eliminarListaConIdLista(Integer idLista) {
        crudCancionesEnLista.eliminarCancionesEnListaPorIdLista(idLista);
    }
}
