package com.proyectopsp.proyectopsp.dao;

import com.proyectopsp.proyectopsp.model.Itinerario;

import java.util.List;

public interface ItinerarioDAO {
    List<Itinerario> findAll();
    Itinerario findById(Integer id);
    Itinerario save(Itinerario itinerario);
    Itinerario update(Integer id, Itinerario itinerario);
    boolean delete(Integer id);
}
