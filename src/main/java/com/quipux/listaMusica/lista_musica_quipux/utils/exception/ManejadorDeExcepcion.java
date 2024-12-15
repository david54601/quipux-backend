package com.quipux.listaMusica.lista_musica_quipux.utils.exception;



import com.quipux.listaMusica.lista_musica_quipux.utils.validation.ValidacionDominio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestControllerAdvice
public class ManejadorDeExcepcion {

    public static final Logger LOGGER = LoggerFactory.getLogger(ManejadorDeExcepcion.class);
    protected static final ConcurrentMap<String, HttpStatus> STATES = new ConcurrentHashMap<>();

    public ManejadorDeExcepcion(){
        STATES.put(ExcepcionCampoObligatorio.class.getSimpleName(),HttpStatus.BAD_REQUEST);
        STATES.put(ExcepcionCampoDuplicado.class.getSimpleName(),HttpStatus.BAD_REQUEST);
        STATES.put(ExcepcionValorNoEncontrado.class.getSimpleName(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExcepcionBase.class)
    public ResponseEntity<Error> solucionarExcepcion(ExcepcionBase e){
        HttpStatus status = STATES.get(e.getClass().getSimpleName());
        Error err = new Error(e.getMensaje());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> solucionarExcepcion(Exception e){
        Error err = new Error(ValidacionDominio.MENSAJE_POR_DEFECTO);
        LOGGER.error(e.getClass().getSimpleName(),e);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }
}
