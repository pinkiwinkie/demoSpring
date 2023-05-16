package com.hh.demoSpring.controller;

import com.hh.demoSpring.repository.UsuarioRepository;
import com.hh.demoSpring.repository.model.Usuario;
import com.hh.demoSpring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //ruta a nivel de clase
public class UsuarioController {
    @Autowired //con esto no hace falta el constructor y tambien crea la conexion
    private UsuarioService usuarioService; //contacto con el front

//    public UsuarioController(UsuarioService usuarioService){
//        this.usuarioService = usuarioService;
//    }

    //@PathVariable en el get es obligatorio
    @GetMapping("/usuarios/{id}") //getById
    public Usuario getById(@PathVariable("id") int id){
        return usuarioService.getUsuarioById(id);
    }
// puedes hacer get y post con la misma ruta
    @PostMapping("/usuarios/")
    public Usuario addUsuario(@RequestBody Usuario usuario){
        return UsuarioService.addUsuario(usuario); //solo lo mandas
    }

    @PutMapping("/usuarios/")
    public Usuario updateUsuario(@RequestBody Usuario usuario){
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public boolean deleteUsuario(@PathVariable("id") int id){
        return usuarioService.deleteUsuario(id);
    }
}
