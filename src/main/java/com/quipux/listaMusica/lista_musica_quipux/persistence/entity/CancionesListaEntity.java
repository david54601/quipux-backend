package com.quipux.listaMusica.lista_musica_quipux.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CANCIONES_EN_LISTA")
@Getter
@Setter
@NoArgsConstructor
public class CancionesListaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_lista_reproduccion")
    private Integer idListaReproduccion;

    @Column(name = "id_cancion")
    private Integer idCancion;
}