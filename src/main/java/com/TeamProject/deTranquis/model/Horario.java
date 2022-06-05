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
@Table (name="horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    Long idHorario;


    @Column(name="DIA")
    String dia;


    @Column(name="HORARIOAPERTURA")
    String horarioApertura;

    @Column(name="HORARIOCIERRE")
    String horarioCierre;
}

