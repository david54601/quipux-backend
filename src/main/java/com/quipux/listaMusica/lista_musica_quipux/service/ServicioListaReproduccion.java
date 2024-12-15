package com.quipux.listaMusica.lista_musica_quipux.service;

import com.quipux.listaMusica.lista_musica_quipux.domain.core.ListaReproduccionParaGuardar;
import com.quipux.listaMusica.lista_musica_quipux.domain.dto.*;
import com.quipux.listaMusica.lista_musica_quipux.domain.repositorio.RepositorioCancion;
import com.quipux.listaMusica.lista_musica_quipux.domain.repositorio.RepositorioCancioneEnLista;
import com.quipux.listaMusica.lista_musica_quipux.domain.repositorio.RepositorioListaReproduccion;
import com.quipux.listaMusica.lista_musica_quipux.utils.exception.*;
import com.quipux.listaMusica.lista_musica_quipux.utils.exception.ExcepcionValorNoEncontrado;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioListaReproduccion {
    private final RepositorioListaReproduccion repositorioListaReproduccion; 
    
    private final RepositorioCancion repositorioCancion; 
    private final RepositorioCancioneEnLista repositorioCancioneEnLista; 

    private static final String VALUE_NOT_FOUND = "Valor no encontrado";
    private static final String NOMBRE_EN_USO = "El nombre de la lista ya está siendo usado";

    public ServicioListaReproduccion(RepositorioListaReproduccion repositorioListaReproduccion, RepositorioCancion repositorioCancion, RepositorioCancioneEnLista repositorioCancioneEnLista) {
        this.repositorioListaReproduccion = repositorioListaReproduccion;
        this.repositorioCancion = repositorioCancion;
        this.repositorioCancioneEnLista = repositorioCancioneEnLista;
    }

    public List<RespuestaListaReproduccionDto> obtenerListasReproduccion(){
        List<RespuestaListaReproduccionDto> respuesta = new ArrayList<>();
        List<ListaReproduccionDto> listaReproduccionDtos = repositorioListaReproduccion.obtenerListasReproduccion();
        llenarRespuestaDeCancionesPorListas(listaReproduccionDtos, respuesta);
        return respuesta;
    }

    private void llenarRespuestaDeCancionesPorListas(List<ListaReproduccionDto> listaReproduccionDtos, List<RespuestaListaReproduccionDto> respuesta){
        listaReproduccionDtos.forEach(dto -> {
            RespuestaListaReproduccionDto respuesta2 = new RespuestaListaReproduccionDto();
            respuesta2.setNombre(dto.getNombre());
            respuesta2.setDescripcion(dto.getDescripcion());
            respuesta2.setCanciones(obtenerCancionesPorLista(dto.getId()));
            respuesta.add(respuesta2);
        });
    }

    private List<CancionDto> obtenerCancionesPorLista(Integer idLista){
        return repositorioCancion.obtenerCancionesPorIdLista(idLista);
    }
    public RespuestaListaReproduccionDto obtenerListaReproduccionPorNombre(String nombre){
        RespuestaListaReproduccionDto respuesta = new RespuestaListaReproduccionDto();
        ListaReproduccionDto listaReproduccionDto = existeListaDeReproduccionConElNombre(nombre);
        List<CancionDto> listaDeCanciones = repositorioCancion.obtenerCancionesPorIdLista(listaReproduccionDto.getId());
        llenarRespuestaConDatosDeListaReproduccion(listaReproduccionDto,respuesta);
        llenarRespuestaConDatosDeCanciones(listaDeCanciones,respuesta);
        return respuesta;
    }

    private ListaReproduccionDto existeListaDeReproduccionConElNombre(String nombre){
        Optional<ListaReproduccionDto> optional = repositorioListaReproduccion.obtenerListaReproduccionPorNombre(nombre);
        if(optional.isEmpty()){
            throw new ExcepcionValorNoEncontrado(VALUE_NOT_FOUND);
        }
        return optional.get();
    }

    @Transactional
    public RespuestaListaReproduccionDto guardarListaReproduccion(PeticionListaReproduccionDto dto){
        validarQueNombreDeListaNoExiste(dto.getNombre());
        ListaReproduccionParaGuardar listaReproduccionParaGuardar = new ListaReproduccionParaGuardar(dto);
        RespuestaListaReproduccionDto respuesta = new RespuestaListaReproduccionDto();
        ListaReproduccionDto respuestaRepositorioLista = repositorioListaReproduccion.guardarListaReproduccion(listaReproduccionParaGuardar.getListaReproduccion());
        List<CancionDto> respuestaRepositorioCanciones = repositorioCancion.guardarCanciones(listaReproduccionParaGuardar.getCanciones());
        repositorioCancioneEnLista.guardarListaYCanciones(crearCancionesEnLista(respuestaRepositorioLista,respuestaRepositorioCanciones));
        llenarRespuestaConDatosDeListaReproduccion(respuestaRepositorioLista, respuesta);
        llenarRespuestaConDatosDeCanciones(respuestaRepositorioCanciones, respuesta);
        return respuesta;
    }

    private void validarQueNombreDeListaNoExiste(String nombre){
        Optional<ListaReproduccionDto> optional = repositorioListaReproduccion.obtenerListaReproduccionPorNombre(nombre);
        if (optional.isPresent()){
            throw new ExcepcionCampoDuplicado(NOMBRE_EN_USO);
        }
    }

    private void llenarRespuestaConDatosDeListaReproduccion(ListaReproduccionDto dto, RespuestaListaReproduccionDto respuesta){
        respuesta.setNombre(dto.getNombre());
        respuesta.setDescripcion(dto.getDescripcion());
    }

    private void llenarRespuestaConDatosDeCanciones(List<CancionDto> dto, RespuestaListaReproduccionDto respuesta){
        respuesta.setCanciones(dto);
    }

    private List<CancionEnListaDto> crearCancionesEnLista(ListaReproduccionDto listaReproduccion, List<CancionDto> canciones){
        List<CancionEnListaDto> cancionesEnLista = new ArrayList<>();
        canciones.forEach(cancionDto -> {
            CancionEnListaDto dto = new CancionEnListaDto();
            dto.setIdCancion(cancionDto.getId());
            dto.setIdListaReproduccion(listaReproduccion.getId());
            cancionesEnLista.add(dto);
        });
        return cancionesEnLista;
    }

    @Transactional
    public void eliminarListaReproduccionPorNombre(String nombre){
        ListaReproduccionDto listaReproduccionDto = existeListaDeReproduccionConElNombre(nombre);
        List<CancionEnListaDto> cancionEnListaDto = repositorioCancioneEnLista.obtenerCancionEnLista(listaReproduccionDto.getId());
        repositorioCancioneEnLista.eliminarListaConIdLista(listaReproduccionDto.getId());
        repositorioListaReproduccion.eliminarListaReproduccionPorId(listaReproduccionDto.getId());
        eliminarCancionesEnLaLista(cancionEnListaDto);
    }

    private void eliminarCancionesEnLaLista(List<CancionEnListaDto> cancionEnListaDtos){
        cancionEnListaDtos.forEach(cancionEnListaDto -> repositorioCancion.eliminarCancionPorId(cancionEnListaDto.getIdCancion()));
    }

}
