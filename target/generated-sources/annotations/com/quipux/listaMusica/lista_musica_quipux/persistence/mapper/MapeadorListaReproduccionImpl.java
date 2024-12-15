package com.quipux.listaMusica.lista_musica_quipux.persistence.mapper;

import com.quipux.listaMusica.lista_musica_quipux.domain.core.ListaReproduccion;
import com.quipux.listaMusica.lista_musica_quipux.domain.dto.ListaReproduccionDto;
import com.quipux.listaMusica.lista_musica_quipux.persistence.entity.ListaReproduccionEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-15T07:14:42-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.40.0.z20241112-1021, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class MapeadorListaReproduccionImpl implements MapeadorListaReproduccion {

    @Override
    public ListaReproduccionEntity convertirAEntity(ListaReproduccion listaReproduccion) {
        if ( listaReproduccion == null ) {
            return null;
        }

        ListaReproduccionEntity listaReproduccionEntity = new ListaReproduccionEntity();

        listaReproduccionEntity.setNombre( listaReproduccion.getNombre() );
        listaReproduccionEntity.setDescripcion( listaReproduccion.getDescripcion() );

        return listaReproduccionEntity;
    }

    @Override
    public ListaReproduccionDto convertirARespuesta(ListaReproduccionEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ListaReproduccionDto listaReproduccionDto = new ListaReproduccionDto();

        listaReproduccionDto.setId( entity.getId() );
        listaReproduccionDto.setNombre( entity.getNombre() );
        listaReproduccionDto.setDescripcion( entity.getDescripcion() );

        return listaReproduccionDto;
    }

    @Override
    public List<ListaReproduccionDto> convertirAListasReproduccionDto(List<ListaReproduccionEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ListaReproduccionDto> list = new ArrayList<ListaReproduccionDto>( entities.size() );
        for ( ListaReproduccionEntity listaReproduccionEntity : entities ) {
            list.add( convertirARespuesta( listaReproduccionEntity ) );
        }

        return list;
    }
}
