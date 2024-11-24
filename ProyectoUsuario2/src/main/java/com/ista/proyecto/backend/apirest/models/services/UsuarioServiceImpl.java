package com.ista.proyecto.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.proyecto.backend.apirest.models.dao.UsuarioDao;
import com.ista.proyecto.backend.apirest.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        usuarioDao.deleteById(id);
    }

    @Override
    @Transactional
    public Usuario update(Usuario usuario, Long id) {
        Usuario usuarioExistente = findById(id);
        if (usuarioExistente != null) {
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setClave(usuario.getClave());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setEstado(usuario.getEstado());
            return usuarioDao.save(usuarioExistente);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
    }
}
