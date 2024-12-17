package com.quipux.listaMusica.lista_musica_quipux.controller;



import com.quipux.listaMusica.lista_musica_quipux.domain.dto.PeticionListaReproduccionDto;

import com.quipux.listaMusica.lista_musica_quipux.domain.dto.RespuestaListaReproduccionDto;
import com.quipux.listaMusica.lista_musica_quipux.service.ServicioListaReproduccion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/listas")
public class ControladorListaReproduccion {

    private final ServicioListaReproduccion servicio;

    public ControladorListaReproduccion(ServicioListaReproduccion servicio) {
        this.servicio = servicio;
    }

    @GetMapping("")
    public ResponseEntity<List<RespuestaListaReproduccionDto>> obtenerListasReproduccion(){
        return ResponseEntity.ok(servicio.obtenerListasReproduccion());
    }

    @GetMapping("/{listName}")
    RespuestaListaReproduccionDto obtenerListaReproduccionPorNombre(@PathVariable("listName") String nombre){
        return servicio.obtenerListaReproduccionPorNombre(nombre);
    }

    @PostMapping("")
    public ResponseEntity<RespuestaListaReproduccionDto> guardarListaReproduccion(@RequestBody PeticionListaReproduccionDto dto){
        return ResponseEntity.ok(servicio.guardarListaReproduccion(dto));
    }

    @DeleteMapping("/{listName}")
    public ResponseEntity<Void> eliminarListaReproduccionPorNombre(@PathVariable("listName") String nombre){
        servicio.eliminarListaReproduccionPorNombre(nombre);
        return ResponseEntity.noContent().build();
    }
}
