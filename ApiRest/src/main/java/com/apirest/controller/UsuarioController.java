package com.apirest.controller;

import com.apirest.model.Usuario;
import com.apirest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("calas-api")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/users")
    public List<Usuario> listarUsers() {
        return service.listarUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Usuario> obtenerUser(@PathVariable Long id) {
        try{
            Usuario usuario = service.obtenerUserForId(id);
            return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public void saveUsers(@RequestBody Usuario usuario){
        service.saveUsers(usuario);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUsers(@RequestBody Usuario usuario,@PathVariable Long id){
        try {
            Usuario usersActual = service.obtenerUserForId(id);

            usersActual.setNombreCompleto(usuario.getNombreCompleto());
            usersActual.setSalario(usuario.getSalario());
            usersActual.setEdad(usuario.getEdad());

            service.saveUsers(usersActual);
            return new ResponseEntity<Usuario>(HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteUsers(@PathVariable Long id){
        service.deleteUsers(id);
    }

}
