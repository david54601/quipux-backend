package com.quipux.listaMusica.lista_musica_quipux.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "lista_reproduccion")
@Getter
@Setter
@NoArgsConstructor
public class ListaReproduccionEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    private String descripcion;
    
}