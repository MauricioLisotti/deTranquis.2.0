package com.TeamProject.deTranquis.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Data
@Entity
@Table (name = "promocion")
public class Promocion {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    Long idPromocion;

    @Column(name="TITULO")
    String titulo;

    @Column(name="DESCRIPCION")
    String descripcion;

    @Column(name="URL_IMAGEN")
    String urlImagen;

    @Column(name="ID_BAR")
    String idBar;
}
