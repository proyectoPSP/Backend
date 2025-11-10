package com.proyectopsp.proyectopsp.dao;

import com.proyectopsp.proyectopsp.model.Usuario;

public interface UsuarioDAO {
    Usuario findById(Integer id);
    Usuario findByUsuario(String usuario);
    Usuario save(Usuario usuario);
    Usuario update(Usuario usuario);
    boolean delete(Usuario usuario);
}
