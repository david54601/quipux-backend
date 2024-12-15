package com.quipux.listaMusica.lista_musica_quipux.repositiry;



import com.quipux.listaMusica.lista_musica_quipux.domain.core.ListaReproduccion;
import com.quipux.listaMusica.lista_musica_quipux.domain.dto.ListaReproduccionDto;

import com.quipux.listaMusica.lista_musica_quipux.domain.repositorio.RepositorioListaReproduccion;

import com.quipux.listaMusica.lista_musica_quipux.persistence.crud.CrudListaReproduccion;
import com.quipux.listaMusica.lista_musica_quipux.persistence.entity.ListaReproduccionEntity;

import com.quipux.listaMusica.lista_musica_quipux.persistence.mapper.MapeadorListaReproduccion;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ImplRepositorioListaReproduccion implements RepositorioListaReproduccion {

    private final CrudListaReproduccion crudListaReproduccion;
    private final MapeadorListaReproduccion mapeadorListaReproduccion;

    public ImplRepositorioListaReproduccion(CrudListaReproduccion crudListaReproduccion, MapeadorListaReproduccion mapeadorListaReproduccion) {
        this.crudListaReproduccion = crudListaReproduccion;
        this.mapeadorListaReproduccion = mapeadorListaReproduccion;
    }

    @Override
    public List<ListaReproduccionDto> obtenerListasReproduccion() {
        return mapeadorListaReproduccion.convertirAListasReproduccionDto((List<ListaReproduccionEntity>) crudListaReproduccion.findAll()) ;
    }

    @Override
    public Optional<ListaReproduccionDto> obtenerListaReproduccionPorNombre(String nombre) {
        return crudListaReproduccion.findByNombre(nombre).map(mapeadorListaReproduccion::convertirARespuesta);
    }

    @Override
    public ListaReproduccionDto guardarListaReproduccion(ListaReproduccion listaReproduccion) {
        ListaReproduccionEntity entity =mapeadorListaReproduccion.convertirAEntity(listaReproduccion);
        return mapeadorListaReproduccion.convertirARespuesta(crudListaReproduccion.save(entity));
    }

    @Override
    public void eliminarListaReproduccionPorId(Integer id) {
        crudListaReproduccion.deleteById(id);
    }
}
