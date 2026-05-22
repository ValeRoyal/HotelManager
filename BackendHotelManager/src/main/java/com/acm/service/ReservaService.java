package com.acm.service;

import com.acm.entity.Reserva;
import com.acm.repository.ReservaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva create(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Reserva getById(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada"));
    }

    public Reserva update(Long id, Reserva reserva) {
        getById(id);
        reserva.setId(id);
        return reservaRepository.save(reserva);
    }

    public void delete(Long id) {
        getById(id);
        reservaRepository.deleteById(id);
    }
}
