package br.com.hotelcompensa.microservice.hotel.controllers;

import br.com.hotelcompensa.microservice.hotel.models.HotelDomain;
import br.com.hotelcompensa.microservice.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(HotelController.URI_BASE)
public class HotelController {

    public static final String URI_BASE = "hotel/v1";
    private HotelService hotelService;

    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @GetMapping("/")
    public ResponseEntity<List<HotelDomain>> findAll(){

        List<HotelDomain> retorno;

        retorno = hotelService.findAll();

        return new ResponseEntity<List<HotelDomain>>(retorno, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public HotelDomain findByIdentifier(@PathVariable("id") final String id) {
        return hotelService.findbyIdentifier(id);
    }

    @PostMapping("/")
    public HotelDomain create(@RequestBody final HotelDomain hotel) {
        return hotelService.create(hotel);
    }

    @PutMapping("/")
    public HotelDomain update(@RequestBody final HotelDomain hotel) {
        return hotelService.update(hotel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final String id) {
        hotelService.delete(id);
    }




}
