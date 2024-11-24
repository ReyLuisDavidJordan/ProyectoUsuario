package com.ista.proyecto.backend.apirest.models.services;

import java.util.List;

import com.ista.proyecto.backend.apirest.models.entity.Usuario;

public interface UsuarioService {

    public List<Usuario> findAll(); // Listar todos los usuarios

    public Usuario save(Usuario usuario); // Guardar un nuevo usuario o actualizar uno existente

    public Usuario findById(Long id); // Buscar un usuario por ID

    public void delete(Long id); // Eliminar un usuario por ID

    public Usuario update(Usuario usuario, Long id); // Actualizar un usuario existente
}
