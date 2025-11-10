package com.proyectopsp.proyectopsp.model;

import lombok.Data;

@Data
public class Usuario {
    private int id;
    private String usuario;
    private String password;

    public Usuario() {}

    public Usuario(int id, String usuario, String password) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
    }
}
