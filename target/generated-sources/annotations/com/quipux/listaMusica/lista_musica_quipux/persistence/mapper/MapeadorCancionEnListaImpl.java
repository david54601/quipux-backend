package com.quipux.listaMusica.lista_musica_quipux.persistence.mapper;

import com.quipux.listaMusica.lista_musica_quipux.domain.dto.CancionEnListaDto;
import com.quipux.listaMusica.lista_musica_quipux.persistence.entity.CancionesListaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-17T13:19:08-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.40.0.z20241112-1021, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class MapeadorCancionEnListaImpl implements MapeadorCancionEnLista {

    @Override
    public CancionesListaEntity convertirACancionesEnListaEntity(CancionEnListaDto dto) {
        if ( dto == null ) {
            return null;
        }

        CancionesListaEntity cancionesListaEntity = new CancionesListaEntity();

        cancionesListaEntity.setId( dto.getId() );
        cancionesListaEntity.setIdListaReproduccion( dto.getIdListaReproduccion() );
        cancionesListaEntity.setIdCancion( dto.getIdCancion() );

        return cancionesListaEntity;
    }

    @Override
    public List<CancionesListaEntity> convertirAListaDeCancioneEntity(List<CancionEnListaDto> listaDtos) {
        if ( listaDtos == null ) {
            return null;
        }

        List<CancionesListaEntity> list = new ArrayList<CancionesListaEntity>( listaDtos.size() );
        for ( CancionEnListaDto cancionEnListaDto : listaDtos ) {
            list.add( convertirACancionesEnListaEntity( cancionEnListaDto ) );
        }

        return list;
    }

    @Override
    public CancionEnListaDto convertirACancionEnListDto(CancionesListaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CancionEnListaDto cancionEnListaDto = new CancionEnListaDto();

        cancionEnListaDto.setId( entity.getId() );
        cancionEnListaDto.setIdListaReproduccion( entity.getIdListaReproduccion() );
        cancionEnListaDto.setIdCancion( entity.getIdCancion() );

        return cancionEnListaDto;
    }

    @Override
    public List<CancionEnListaDto> convertirAListDeCancionesDto(List<CancionesListaEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CancionEnListaDto> list = new ArrayList<CancionEnListaDto>( entities.size() );
        for ( CancionesListaEntity cancionesListaEntity : entities ) {
            list.add( convertirACancionEnListDto( cancionesListaEntity ) );
        }

        return list;
    }
}
