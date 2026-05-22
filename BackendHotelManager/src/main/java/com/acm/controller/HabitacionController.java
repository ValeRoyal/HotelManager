package com.acm.controller;

import com.acm.entity.Habitacion;
import com.acm.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {

    @Autowired
    private  HabitacionService habitacionService;

    @GetMapping
    public List<Habitacion> listAll() {
        return habitacionService.findAll();
    }

    @GetMapping("/{id}")
    public Habitacion getById(@PathVariable Long id) {
        return habitacionService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Habitacion create(@RequestBody Habitacion habitacion) {
        return habitacionService.create(habitacion);
    }

    @PutMapping("/{id}")
    public Habitacion update(@PathVariable Long id, @RequestBody Habitacion habitacion) {
        return habitacionService.update(id, habitacion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        habitacionService.delete(id);
    }
}
