package com.acm.controller;

import com.acm.entity.Servicio;
import com.acm.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public List<Servicio> listAll() {
        return servicioService.findAll();
    }

    @GetMapping("/{id}")
    public Servicio getById(@PathVariable Long id) {
        return servicioService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servicio create(@RequestBody Servicio servicio) {
        return servicioService.create(servicio);
    }

    @PutMapping("/{id}")
    public Servicio update(@PathVariable Long id, @RequestBody Servicio servicio) {
        return servicioService.update(id, servicio);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        servicioService.delete(id);
    }
}
