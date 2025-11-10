package com.proyectopsp.proyectopsp.dao;

import com.proyectopsp.proyectopsp.model.Itinerario;
import com.proyectopsp.proyectopsp.model.Usuario;

import java.util.List;

public interface ItinerarioDAO {
    List<Itinerario> findAll();
    List<Itinerario> findByUsuario(Usuario usuario);
    Itinerario findById(Integer id);
    Itinerario save(Itinerario itinerario);
    Itinerario update(Integer id, Itinerario itinerario);
    boolean delete(Integer id);
}
