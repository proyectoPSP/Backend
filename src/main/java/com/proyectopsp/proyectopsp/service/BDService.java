package com.proyectopsp.proyectopsp.service;

import com.proyectopsp.proyectopsp.entity.Itinerario;
import com.proyectopsp.proyectopsp.entity.Usuario;
import com.proyectopsp.proyectopsp.repository.ItinerarioRepository;
import com.proyectopsp.proyectopsp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BDService {
    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private ItinerarioRepository itinerarioRepo;

    public List<Itinerario> findAllItinerarios() {
        return itinerarioRepo.findAll();
    }

    public List<Usuario> findAllUsuarios() {
        return usuarioRepo.findAll();
    }

    //public List<Itinerario> findByUsuario(Usuario usuario) { return itinerarioRepo.findByUsuario(usuario); }
}
