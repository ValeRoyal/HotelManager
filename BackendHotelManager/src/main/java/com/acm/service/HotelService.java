package com.acm.service;

import com.acm.entity.Hotel;
import com.acm.repository.HotelRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    public Hotel getById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel no encontrado"));
    }

    public Hotel update(Long id, Hotel hotel) {
        getById(id);
        hotel.setId(id);
        return hotelRepository.save(hotel);
    }

    public void delete(Long id) {
        getById(id);
        hotelRepository.deleteById(id);
    }
}
