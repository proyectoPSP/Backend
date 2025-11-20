package com.proyectopsp.proyectopsp.repository;

import com.proyectopsp.proyectopsp.entity.Itinerario;
import com.proyectopsp.proyectopsp.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItinerarioRepository extends JpaRepository<Itinerario,Long> {
    //@Query("SELECT i FROM Itinerario i WHERE :u = true OR i.usuario = :u")
    //List<Itinerario> findByUsuario(@Param("u")Usuario u);
}
