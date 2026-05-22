package com.acm.controller;

import com.acm.entity.Hotel;
import com.acm.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoteles")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> listAll() {
        return hotelService.findAll();
    }

    @GetMapping("/{id}")
    public Hotel getById(@PathVariable Long id) {
        return hotelService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Hotel create(@RequestBody Hotel hotel) {
        return hotelService.create(hotel);
    }

    @PutMapping("/{id}")
    public Hotel update(@PathVariable Long id, @RequestBody Hotel hotel) {
        return hotelService.update(id, hotel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        hotelService.delete(id);
    }
}
