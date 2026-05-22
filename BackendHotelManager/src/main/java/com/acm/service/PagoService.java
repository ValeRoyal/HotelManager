package com.acm.service;

import com.acm.entity.Pago;
import com.acm.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PagoService {

    @Autowired
    private  PagoRepository pagoRepository;

    public Pago create(Pago pago) {
        return pagoRepository.save(pago);
    }

    public List<Pago> findAll() {
        return pagoRepository.findAll();
    }

    public Pago getById(Long id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pago no encontrado"));
    }

    public Pago update(Long id, Pago pago) {
        getById(id);
        pago.setId(id);
        return pagoRepository.save(pago);
    }

    public void delete(Long id) {
        getById(id);
        pagoRepository.deleteById(id);
    }
}
