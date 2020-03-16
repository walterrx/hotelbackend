package br.com.hotelcompensa.microservice.hotel.repositories;

import br.com.hotelcompensa.microservice.hotel.models.HotelDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HotelRepository extends MongoRepository<HotelDomain, String> {
}
