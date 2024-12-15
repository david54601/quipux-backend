package com.quipux.listaMusica.lista_musica_quipux.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "CANCIONES")
@Getter
@Setter
@NoArgsConstructor
public class CancionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String artista;
    private String album;
    private String anno;
    private String genero;

}