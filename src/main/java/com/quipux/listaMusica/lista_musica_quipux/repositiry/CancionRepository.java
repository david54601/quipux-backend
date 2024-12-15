
package com.quipux.listaMusica.lista_musica_quipux.repositiry;



import com.quipux.listaMusica.lista_musica_quipux.domain.core.Cancion;
import com.quipux.listaMusica.lista_musica_quipux.domain.dto.CancionDto;

import com.quipux.listaMusica.lista_musica_quipux.domain.repositorio.RepositorioCancion;
import com.quipux.listaMusica.lista_musica_quipux.persistence.crud.CrudCancion;
import com.quipux.listaMusica.lista_musica_quipux.persistence.entity.CancionEntity;
import com.quipux.listaMusica.lista_musica_quipux.persistence.mapper.MapeadorCancion;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public class CancionRepository implements RepositorioCancion {
    private final CrudCancion crudCancion;
    private final MapeadorCancion mapeadorCancion;

    public CancionRepository(CrudCancion crudCancion, MapeadorCancion mapeadorCancion) {
        this.crudCancion = crudCancion;
        this.mapeadorCancion = mapeadorCancion;
    }

    @Override
    public List<CancionDto> obtenerCancionesPorIdLista(Integer idLista) {
        return mapeadorCancion.convertiAListaCancionesDto(crudCancion.obtenerCancionesPorLista(idLista));
    }
    

    @Override
    public List<CancionDto> guardarCanciones(List<Cancion> canciones) {
        return mapeadorCancion.convertiAListaCancionesDto((List<CancionEntity>) crudCancion.saveAll(mapeadorCancion.convertirAListaEntity(canciones)));
    }

    @Override
    public void eliminarCancionPorId(Integer id) {
        crudCancion.deleteById(id);
    }
}
