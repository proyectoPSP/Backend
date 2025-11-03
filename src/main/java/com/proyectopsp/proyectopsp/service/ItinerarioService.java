package com.proyectopsp.proyectopsp.service;

import com.proyectopsp.proyectopsp.dao.ItinerarioDAO;
import com.proyectopsp.proyectopsp.model.Itinerario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItinerarioService {
    private final ItinerarioDAO itinerarioDAO;

    public ItinerarioService(ItinerarioDAO itinerarioDAO) {
        this.itinerarioDAO = itinerarioDAO;
    }

    public List<Itinerario> getAll() {
        return itinerarioDAO.findAll();
    }

    public Itinerario getById(int id) {
        return itinerarioDAO.findById(id);
    }

    public Itinerario create(Itinerario itinerario) {
        return itinerarioDAO.save(itinerario);
    }

    public Itinerario update(int id, Itinerario itinerario) {
        return itinerarioDAO.update(id, itinerario);
    }

    public boolean delete(int id) {
        return itinerarioDAO.delete(id);
    }
}
