package com.quipux.listaMusica.lista_musica_quipux.utils.exception;

import lombok.Getter;

@Getter
public abstract class ExcepcionBase extends RuntimeException{
    private final String mensaje;

    protected ExcepcionBase(String mensaje){
        super(mensaje);
        this.mensaje = mensaje;
    }
}
