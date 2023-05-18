package com.hh.demoSpring.service;

import com.hh.demoSpring.repository.model.Usuario;
import com.hh.demoSpring.repository.model.UsuarioDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioDBService {
    @Autowired
    public UsuarioDBRepository repository;

    public List<Usuario> getAllUsuarios() throws SQLException {
        return repository.getAllUsuarios();
    }
    public Usuario addUsuario(Usuario usuario) {
        return repository.addUsuario(usuario);
    }
}
