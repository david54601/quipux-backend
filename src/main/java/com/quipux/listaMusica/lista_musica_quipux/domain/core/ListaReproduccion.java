package com.quipux.listaMusica.lista_musica_quipux.domain.core;



import static com.quipux.listaMusica.lista_musica_quipux.utils.validation.ValidacionDominio.*;

import lombok.Getter;

@Getter
public class ListaReproduccion {
    private String nombre;
    private String descripcion;

    private ListaReproduccion(){}
    private ListaReproduccion(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public static ListaReproduccion of(String nombre, String descripcion){
        campoObligatorio(nombre, obtenerMensaje("nombre"));
        campoObligatorio(descripcion, obtenerMensaje("descripcion"));
        return new ListaReproduccion(nombre,descripcion);
    }

}
