package com.ista.proyecto.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ista.proyecto.backend.apirest.models.entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {

}
