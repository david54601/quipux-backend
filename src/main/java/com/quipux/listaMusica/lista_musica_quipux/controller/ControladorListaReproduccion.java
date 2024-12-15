package com.quipux.listaMusica.lista_musica_quipux.controller;



import com.quipux.listaMusica.lista_musica_quipux.domain.dto.PeticionListaReproduccionDto;

import com.quipux.listaMusica.lista_musica_quipux.domain.dto.RespuestaListaReproduccionDto;
import com.quipux.listaMusica.lista_musica_quipux.service.ServicioListaReproduccion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lists")
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
    public ResponseEntity<RespuestaListaReproduccionDto> obtenerListaReproduccionPorNombre(@PathVariable("listName") String nombre){
        RespuestaListaReproduccionDto lista= servicio.obtenerListaReproduccionPorNombre(nombre);
        if(lista==null){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(lista);
    }

   public ResponseEntity<RespuestaListaReproduccionDto> guardarListaReproduccion(@RequestBody PeticionListaReproduccionDto dto) {
    if (dto.getNombre() == null || dto.getNombre().isEmpty()) {
        return ResponseEntity.badRequest().build();
    }
    RespuestaListaReproduccionDto nuevaLista = servicio.guardarListaReproduccion(dto);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
          .path("/{listName}")
          .buildAndExpand(nuevaLista.getNombre())
          .toUri();
    return ResponseEntity.created(location).body(nuevaLista);
}

    @DeleteMapping("/{listName}")
    public ResponseEntity<Void> eliminarListaReproduccionPorNombre(@PathVariable("listName") String nombre){
        try{        
            servicio.eliminarListaReproduccionPorNombre(nombre);
            return ResponseEntity.noContent().build();
         }catch(Error e){
         
           return ResponseEntity.status(404).build();
         }
    }
}
