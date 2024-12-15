package com.quipux.listaMusica.lista_musica_quipux.domain.core;



import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

import com.quipux.listaMusica.lista_musica_quipux.domain.dto.PeticionListaReproduccionDto;

@Getter
public class ListaReproduccionParaGuardar {

    ListaReproduccion listaReproduccion;
    List<Cancion> canciones;

    public ListaReproduccionParaGuardar(PeticionListaReproduccionDto dto){
        this.listaReproduccion = ListaReproduccion.of(dto.getNombre(),dto.getDescripcion());
        this.canciones = dto.getCanciones().stream().map(Cancion::of).collect(Collectors.toList());
    }
}