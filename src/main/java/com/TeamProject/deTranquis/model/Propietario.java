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
@Table(name = "propietario")

public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long idProp;

    @Column(name = "NOMBREUSUARIO")
    String nombreUsuario;

    @Column(name = "CLAVE")
    String clave;

    @Column(name = "NOMBRE")
    String nombreProp;

    @Column(name = "APELLIDO")
    String apellidoProp;

    @Column(name = "TELEFONO")
    String telefonoProp;
}
