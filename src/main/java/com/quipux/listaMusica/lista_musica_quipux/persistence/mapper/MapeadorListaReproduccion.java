package com.quipux.listaMusica.lista_musica_quipux.persistence.mapper;

import com.quipux.listaMusica.lista_musica_quipux.domain.core.ListaReproduccion;
import com.quipux.listaMusica.lista_musica_quipux.domain.dto.ListaReproduccionDto;
import com.quipux.listaMusica.lista_musica_quipux.persistence.entity.ListaReproduccionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeadorListaReproduccion {
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    ListaReproduccionEntity convertirAEntity(ListaReproduccion listaReproduccion);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    ListaReproduccionDto convertirARespuesta(ListaReproduccionEntity entity);
    List<ListaReproduccionDto> convertirAListasReproduccionDto(List<ListaReproduccionEntity> entities);
} 
