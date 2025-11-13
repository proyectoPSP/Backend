package com.proyectopsp.proyectopsp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private final String URL = "jdbc:sqlite:proyectopsp.db";

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
