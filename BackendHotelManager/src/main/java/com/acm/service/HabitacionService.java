package com.acm.service;

import com.acm.entity.Habitacion;
import com.acm.repository.HabitacionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;

    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    public Habitacion create(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    public List<Habitacion> findAll() {
        return habitacionRepository.findAll();
    }

    public Habitacion getById(Long id) {
        return habitacionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Habitación no encontrada"));
    }

    public Habitacion update(Long id, Habitacion habitacion) {
        getById(id);
        habitacion.setId(id);
        return habitacionRepository.save(habitacion);
    }

    public void delete(Long id) {
        getById(id);
        habitacionRepository.deleteById(id);
    }
}
