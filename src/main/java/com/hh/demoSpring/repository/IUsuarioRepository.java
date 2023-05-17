package com.hh.demoSpring.repository;

import com.hh.demoSpring.repository.model.Usuario;

import java.util.List;

public interface IUsuarioRepository {
    Usuario addUsuario(Usuario usuario);
    Usuario updateUsuario(Usuario usuario);
    boolean deleteUsuario(int id);
    Usuario getUsuarioById(int id);
    List<Usuario> getAllUsuarios();
}
