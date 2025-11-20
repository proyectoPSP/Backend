package com.proyectopsp.proyectopsp.repository;

import com.proyectopsp.proyectopsp.entity.Itinerario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItinerarioRepository extends JpaRepository<Itinerario,Long> {
}
