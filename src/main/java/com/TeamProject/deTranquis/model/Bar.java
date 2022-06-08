package com.TeamProject.deTranquis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;


@Data
@Entity
@Table(name = "bar")

public class Bar {
    @Autowired
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long idBar;


    @Column(name = "NOMBRE")
    String nombre;


    @Column(name = "TELEFONO")
    String telefono;


    @Column(name = "IMAGENBAR")
    String imagenbar;


    @Column(name = "DIRECCION")
    String direccion;


    @Column(name = "CATPRECIO")
    String catprecio;


    @Column(name = "AREA")
    String area;


    @Column(name = "CATEGORIA")
    String categoria;

    @Column(name = "DESCRIPCION")
    String descripcion;


    @Column(name = "ESPECIALIDADES")
    String especialidades;


    @Column(name = "redessociales")
    String redessociales;


    @Column(name = "iduserprop")
    String iduserprop;
}

