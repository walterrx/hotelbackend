package br.com.hotelcompensa.microservice.hotel.services;

import br.com.hotelcompensa.microservice.hotel.models.HotelDomain;
import br.com.hotelcompensa.microservice.hotel.repositories.HotelRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class HotelService {

private HotelRepository hotelRepository;


    public HotelService(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    @Cacheable(cacheNames = HotelDomain.CACHE_NAME, key="#hoteis")
    public List<HotelDomain> findAll() {
        return hotelRepository.findAll();
    }


    public HotelDomain findbyIdentifier(final String id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " de Hotel não foi encontrado !"));
    }

    @CacheEvict(cacheNames = HotelDomain.CACHE_NAME, allEntries = true)
    public HotelDomain create(final HotelDomain hotel) {
        return hotelRepository.save(hotel);
    }

    @CachePut(cacheNames = HotelDomain.CACHE_NAME, key="#hotel.getNome()")
    public HotelDomain update(final HotelDomain hotel) {
        if(hotel.getNome()== null) {
            throw new EntityNotFoundException("Hotel não encontrado !");
        }

        return hotelRepository.save(hotel);
    }

    @CacheEvict(cacheNames = HotelDomain.CACHE_NAME, key="#hotel.id")
    public void delete(final String id) {
        if(id == null) {
            throw new EntityNotFoundException("Hotel não encontrado !");
        }

        hotelRepository.deleteById(id);
    }


}
