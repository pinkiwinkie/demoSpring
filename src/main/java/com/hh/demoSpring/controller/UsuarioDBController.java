package com.hh.demoSpring.controller;


import com.hh.demoSpring.repository.model.Usuario;
import com.hh.demoSpring.service.UsuarioDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apidb")
public class UsuarioDBController {
    @Autowired
    public UsuarioDBService service;
    @GetMapping("/usuariosdb/")
    public ResponseEntity<?> getAllUsuarios(){
        try {
            return new ResponseEntity<>(service.getAllUsuarios(), HttpStatus.OK);
        } catch(SQLException e){
            Map<String,Object> response = new HashMap<>();
            response.put("code",e.getErrorCode());
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/usuariosdb/")
    public ResponseEntity<?> addUsuario(@RequestBody Usuario usuario){
        Usuario u = service.addUsuario(usuario); //solo lo mandas
        if (u == null)
            return new ResponseEntity<>("No se pudo insertar", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
}
