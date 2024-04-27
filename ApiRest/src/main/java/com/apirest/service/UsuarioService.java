package com.apirest.service;

import com.apirest.model.Usuario;
import com.apirest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listarUsers(){
        return repository.findAll();
    }

    public Usuario obtenerUserForId(Long id){
        return repository.findById(id).get();
    }

    public void saveUsers(Usuario usuario){
        repository.save(usuario);
    }

    public void deleteUsers(Long id) {
        repository.deleteById(id);
    }
}
