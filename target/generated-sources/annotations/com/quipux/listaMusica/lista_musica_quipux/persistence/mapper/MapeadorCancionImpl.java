package com.quipux.listaMusica.lista_musica_quipux.persistence.mapper;

import com.quipux.listaMusica.lista_musica_quipux.domain.core.Cancion;
import com.quipux.listaMusica.lista_musica_quipux.domain.dto.CancionDto;
import com.quipux.listaMusica.lista_musica_quipux.persistence.entity.CancionEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-15T09:18:06-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.40.0.z20241112-1021, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class MapeadorCancionImpl implements MapeadorCancion {

    @Override
    public CancionEntity convertirAEntity(Cancion cancion) {
        if ( cancion == null ) {
            return null;
        }

        CancionEntity cancionEntity = new CancionEntity();

        cancionEntity.setId( cancion.getId() );
        cancionEntity.setTitulo( cancion.getTitulo() );
        cancionEntity.setArtista( cancion.getArtista() );
        cancionEntity.setAnno( cancion.getAnno() );
        cancionEntity.setGenero( cancion.getGenero() );
        cancionEntity.setAlbum( cancion.getAlbum() );

        return cancionEntity;
    }

    @Override
    public List<CancionEntity> convertirAListaEntity(List<Cancion> listaCanciones) {
        if ( listaCanciones == null ) {
            return null;
        }

        List<CancionEntity> list = new ArrayList<CancionEntity>( listaCanciones.size() );
        for ( Cancion cancion : listaCanciones ) {
            list.add( convertirAEntity( cancion ) );
        }

        return list;
    }

    @Override
    public CancionDto convertirACancionDto(CancionEntity cancionEntity) {
        if ( cancionEntity == null ) {
            return null;
        }

        CancionDto cancionDto = new CancionDto();

        cancionDto.setId( cancionEntity.getId() );
        cancionDto.setTitulo( cancionEntity.getTitulo() );
        cancionDto.setArtista( cancionEntity.getArtista() );
        cancionDto.setAnno( cancionEntity.getAnno() );
        cancionDto.setGenero( cancionEntity.getGenero() );
        cancionDto.setAlbum( cancionEntity.getAlbum() );

        return cancionDto;
    }

    @Override
    public List<CancionDto> convertiAListaCancionesDto(List<CancionEntity> cancionEntityList) {
        if ( cancionEntityList == null ) {
            return null;
        }

        List<CancionDto> list = new ArrayList<CancionDto>( cancionEntityList.size() );
        for ( CancionEntity cancionEntity : cancionEntityList ) {
            list.add( convertirACancionDto( cancionEntity ) );
        }

        return list;
    }
}
