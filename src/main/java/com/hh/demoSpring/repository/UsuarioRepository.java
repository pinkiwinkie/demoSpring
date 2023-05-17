package com.hh.demoSpring.repository;

import com.hh.demoSpring.repository.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements IUsuarioRepository{

    private List<Usuario>usuarios;
    public UsuarioRepository(){
        usuarios = new ArrayList<>();
        usuarios.add(Usuario.builder().id(1).nombre("ppt").apellidos("ppt").build());
        usuarios.add(Usuario.builder().id(2).nombre("mmr").apellidos("mmr").build());
    }

    @Override
    public Usuario addUsuario(Usuario usuario) {
        if (!usuarios.contains(usuario)){
            usuarios.add(usuario);
            return usuario;
        }
        return null;
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        Usuario user = getUsuarioById(usuario.getId());
        if (user != null){
            usuario.setNombre(usuario.getNombre());
            usuario.setApellidos(usuario.getApellidos());
        }
        return usuario;
    }

    @Override
    public boolean deleteUsuario(int id) {
        Usuario usuario = getUsuarioById(id);
        if (usuario != null){
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }

    @Override
    public Usuario getUsuarioById(int id) {
        Optional<Usuario> usuarioOptional = usuarios.stream().filter(usuario ->
                usuario.getId() == id).findFirst();
        if (usuarioOptional.isPresent())
            return usuarioOptional.get();
        return null;
        //return usuarioOptional.orElse(null);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarios;
    }
}
