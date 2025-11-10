package com.proyectopsp.proyectopsp.dao;

import com.proyectopsp.proyectopsp.model.Itinerario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItinerarioDAOImpl implements ItinerarioDAO {
    private final Map<Integer, Itinerario> itinerarios = new HashMap<>();
    private int nextId = 1;

    @Override
    public List<Itinerario> findAll() {
        return new ArrayList<>(itinerarios.values());
    }

    @Override
    public Itinerario findById(Integer id) {
        return itinerarios.get(id);
    }

    @Override
    public Itinerario save(Itinerario itinerario) {
        itinerario.setId(nextId++);
        itinerarios.put(itinerario.getId(), itinerario);
        return itinerario;
    }

    // Posiblemente se elimine mas adelante
    @Override
    public Itinerario update(Integer id, Itinerario itinerario) {
        if (itinerarios.containsKey(id)) {
            itinerario.setId(id);
            itinerarios.put(id, itinerario);
        }
        return itinerario;
    }

    @Override
    public boolean delete(Integer id) {
        return itinerarios.remove(id) != null;
    }
}
