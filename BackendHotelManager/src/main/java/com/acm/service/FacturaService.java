package com.acm.service;

import com.acm.entity.Factura;
import com.acm.repository.FacturaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FacturaService {

    private final FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public Factura create(Factura factura) {
        return facturaRepository.save(factura);
    }

    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }

    public Factura getById(Long id) {
        return facturaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Factura no encontrada"));
    }

    public Factura update(Long id, Factura factura) {
        getById(id);
        factura.setId(id);
        return facturaRepository.save(factura);
    }

    public void delete(Long id) {
        getById(id);
        facturaRepository.deleteById(id);
    }
}
