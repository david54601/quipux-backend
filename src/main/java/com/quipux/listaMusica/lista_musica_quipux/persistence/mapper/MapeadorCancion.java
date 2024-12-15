package com.quipux.listaMusica.lista_musica_quipux.persistence.mapper;


import com.quipux.listaMusica.lista_musica_quipux.domain.core.Cancion;
import com.quipux.listaMusica.lista_musica_quipux.domain.dto.CancionDto;

import com.quipux.listaMusica.lista_musica_quipux.persistence.entity.CancionEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeadorCancion {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "titulo", target = "titulo")
    @Mapping(source = "artista", target = "artista")
    @Mapping(source = "anno", target = "anno")
    @Mapping(source = "genero", target = "genero")
    CancionEntity convertirAEntity(Cancion cancion);
    List<CancionEntity> convertirAListaEntity(List<Cancion> listaCanciones);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "titulo", target = "titulo")
    @Mapping(source = "artista", target = "artista")
    @Mapping(source = "anno", target = "anno")
    @Mapping(source = "genero", target = "genero")
    CancionDto convertirACancionDto(CancionEntity cancionEntity);
    List<CancionDto> convertiAListaCancionesDto(List<CancionEntity> cancionEntityList);
}