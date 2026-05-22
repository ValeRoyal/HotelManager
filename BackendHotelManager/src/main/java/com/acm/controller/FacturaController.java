package com.acm.controller;

import com.acm.entity.Factura;
import com.acm.service.FacturaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public List<Factura> listAll() {
        return facturaService.findAll();
    }

    @GetMapping("/{id}")
    public Factura getById(@PathVariable Long id) {
        return facturaService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Factura create(@RequestBody Factura factura) {
        return facturaService.create(factura);
    }

    @PutMapping("/{id}")
    public Factura update(@PathVariable Long id, @RequestBody Factura factura) {
        return facturaService.update(id, factura);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        facturaService.delete(id);
    }
}
