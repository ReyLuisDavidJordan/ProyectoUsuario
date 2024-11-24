package com.ista.proyecto.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.proyecto.backend.apirest.models.entity.Usuario;
import com.ista.proyecto.backend.apirest.models.services.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;

  
    @GetMapping("/usuario")
    public List<Usuario> index() {
        return usuarioService.findAll();
    }

 
    @GetMapping("/usuario/{id}")
    public Usuario show(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

   
    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

  
    @DeleteMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        usuarioService.delete(id);
    }
    @PutMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
        Usuario usuarioExistente = usuarioService.findById(id);

        if (usuarioExistente != null) {
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setClave(usuario.getClave());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setEstado(usuario.getEstado());
            return usuarioService.save(usuarioExistente);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }
    
}
