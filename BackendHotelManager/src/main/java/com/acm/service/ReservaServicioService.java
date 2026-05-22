package com.acm.service;

import com.acm.entity.ReservaServicio;
import com.acm.repository.ReservaServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReservaServicioService {

    @Autowired
    private ReservaServicioRepository reservaServicioRepository;

    public ReservaServicio create(ReservaServicio reservaServicio) {
        return reservaServicioRepository.save(reservaServicio);
    }

    public List<ReservaServicio> findAll() {
        return reservaServicioRepository.findAll();
    }

    public ReservaServicio getById(Long id) {
        return reservaServicioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Consumo de servicio no encontrado"));
    }

    public ReservaServicio update(Long id, ReservaServicio reservaServicio) {
        getById(id);
        reservaServicio.setId(id);
        return reservaServicioRepository.save(reservaServicio);
    }

    public void delete(Long id) {
        getById(id);
        reservaServicioRepository.deleteById(id);
    }
}
