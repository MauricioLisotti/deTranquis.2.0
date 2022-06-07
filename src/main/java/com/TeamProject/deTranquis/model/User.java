package com.TeamProject.deTranquis.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User {

    @Autowired
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;
}
