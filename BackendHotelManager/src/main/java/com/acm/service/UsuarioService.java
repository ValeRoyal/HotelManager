package com.acm.service;

import com.acm.entity.Usuario;
import com.acm.repository.UsarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsarioRepository usarioRepository;

    public Usuario create(Usuario usuario) {
        return usarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return usarioRepository.findAll();
    }

    public Usuario getById(Long id) {
        return usarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
    }

    public Usuario update(Long id, Usuario usuario) {
        getById(id);
        usuario.setId(id);
        return usarioRepository.save(usuario);
    }

    public void delete(Long id) {
        getById(id);
        usarioRepository.deleteById(id);
    }
}
