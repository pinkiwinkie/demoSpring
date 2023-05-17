package com.hh.demoSpring.controller;
import com.hh.demoSpring.repository.model.Usuario;
import com.hh.demoSpring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//controller->service->repository
@RestController //maneja las rutas
@RequestMapping("/api") //ruta a nivel de clase
public class UsuarioController {
    @Autowired //con esto no hace falta el constructor y tambien crea la conexion
    private UsuarioService usuarioService; //contacto con el front

//    public UsuarioController(UsuarioService usuarioService){
//        this.usuarioService = usuarioService;
//    }

    //@PathVariable en el get es obligatorio
    @GetMapping("/usuarios/{id}") //getById
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        Usuario u= usuarioService.getUsuarioById(id);
        if (u == null)
            return new ResponseEntity<>("No se pudo obtener", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
// puedes hacer get y post con la misma ruta
    @PostMapping("/usuarios/")
    public ResponseEntity<?> addUsuario(@RequestBody Usuario usuario){
        Usuario u = usuarioService.addUsuario(usuario); //solo lo mandas
        if (u == null)
            return new ResponseEntity<>("No se pudo insertar", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
// put y post estan hechos para que se le mande el objeto completo.
    @PutMapping("/usuarios/")
    public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario){
        Usuario u = usuarioService.updateUsuario(usuario);
        if (u == null)
            return new ResponseEntity<>("No se pudo actualizar", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") int id){
        boolean b = usuarioService.deleteUsuario(id);
        if (!b)
            return new ResponseEntity<>("No se pudo eliminar", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

    @GetMapping("/usuarios/")
    public ResponseEntity<?> getAllUsuarios() {
        List<Usuario> users =  usuarioService.getAllUsuarios();
        if (users == null)
            return new ResponseEntity<>("No hay usuarios", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    //metadata para obtener informacion de la bbdd como por ejemplo los procedimiento, tablas...
}
