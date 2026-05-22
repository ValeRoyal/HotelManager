package com.acm.service;

import com.acm.entity.Servicio;
import com.acm.repository.ServicioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServicioService {

    private final ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public Servicio create(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public List<Servicio> findAll() {
        return servicioRepository.findAll();
    }

    public Servicio getById(Long id) {
        return servicioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Servicio no encontrado"));
    }

    public Servicio update(Long id, Servicio servicio) {
        getById(id);
        servicio.setId(id);
        return servicioRepository.save(servicio);
    }

    public void delete(Long id) {
        getById(id);
        servicioRepository.deleteById(id);
    }
}
