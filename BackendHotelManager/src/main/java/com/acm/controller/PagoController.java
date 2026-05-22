package com.acm.controller;

import com.acm.entity.Pago;
import com.acm.service.PagoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping
    public List<Pago> listAll() {
        return pagoService.findAll();
    }

    @GetMapping("/{id}")
    public Pago getById(@PathVariable Long id) {
        return pagoService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pago create(@RequestBody Pago pago) {
        return pagoService.create(pago);
    }

    @PutMapping("/{id}")
    public Pago update(@PathVariable Long id, @RequestBody Pago pago) {
        return pagoService.update(id, pago);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        pagoService.delete(id);
    }
}
