package com.quipux.listaMusica.lista_musica_quipux.persistence.mapper;


import com.quipux.listaMusica.lista_musica_quipux.domain.dto.CancionEnListaDto;
import com.quipux.listaMusica.lista_musica_quipux.persistence.entity.CancionesListaEntity;



import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapeadorCancionEnLista {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "idListaReproduccion", target = "idListaReproduccion")
    @Mapping(source = "idCancion", target = "idCancion")
    CancionesListaEntity convertirACancionesEnListaEntity(CancionEnListaDto dto);
    
    List<CancionesListaEntity> convertirAListaDeCancioneEntity(List<CancionEnListaDto> listaDtos);

    @InheritInverseConfiguration
    CancionEnListaDto convertirACancionEnListDto(CancionesListaEntity entity);
    List<CancionEnListaDto> convertirAListDeCancionesDto(List<CancionesListaEntity> entities);

}
