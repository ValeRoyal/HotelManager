package com.acm.controller;

import com.acm.entity.ReservaServicio;
import com.acm.service.ReservaServicioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva-servicios")
public class ReservaServicioController {

    private final ReservaServicioService reservaServicioService;

    public ReservaServicioController(ReservaServicioService reservaServicioService) {
        this.reservaServicioService = reservaServicioService;
    }

    @GetMapping
    public List<ReservaServicio> listAll() {
        return reservaServicioService.findAll();
    }

    @GetMapping("/{id}")
    public ReservaServicio getById(@PathVariable Long id) {
        return reservaServicioService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReservaServicio create(@RequestBody ReservaServicio reservaServicio) {
        return reservaServicioService.create(reservaServicio);
    }

    @PutMapping("/{id}")
    public ReservaServicio update(@PathVariable Long id, @RequestBody ReservaServicio reservaServicio) {
        return reservaServicioService.update(id, reservaServicio);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        reservaServicioService.delete(id);
    }
}
