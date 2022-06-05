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
@Table(name = "bar")

public class Bar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long idBar;


    @Column(name = "NOMBRE")
    String nombreBar;


    @Column(name = "TELEFONO")
    String telefonoBar;


    @Column(name = "IMAGENBAR")
    String imagenBar;


    @Column(name = "DIRECCION")
    String direccionBar;


    @Column(name = "CATPRECIO")
    String catPrecio;


    @Column(name = "AREA")
    String areabar;


    @Column(name = "CATEGORIA")
    String categoriaBar;

    @Column(name = "DESCRIPCION")
    String descripcionBar;


    @Column(name = "ESPECIALIDADES")
    String especialidadesBar;


    @Column(name = "redessociales")
    String redesSociales;


    @Column(name = "id_propietario_propietario")
    String idPropietario;
}

