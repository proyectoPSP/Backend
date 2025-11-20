package com.proyectopsp.proyectopsp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data // Crea todos los getters y setters
@Entity // Define la clase como una entidad para la base de datos
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private boolean esAdmin; // 0 = no admin | 1 = admin
}
