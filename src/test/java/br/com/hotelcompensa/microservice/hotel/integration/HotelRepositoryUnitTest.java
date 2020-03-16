package br.com.hotelcompensa.microservice.hotel.integration;

import br.com.hotelcompensa.microservice.hotel.controllers.HotelController;
import br.com.hotelcompensa.microservice.hotel.models.HotelDomain;
import br.com.hotelcompensa.microservice.hotel.repositories.HotelRepository;
import lombok.var;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.atomicReferenceFieldUpdater;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@DataMongoTest
@DirtiesContext
public class HotelRepositoryUnitTest {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Before
    public void init() {

        hotelRepository.deleteAll();


        hotelRepository.save( new HotelDomain("Walter", "teste", "000","sao paulo", "SP","brasil" ));
        hotelRepository.save( new HotelDomain("Gianela", "teste", "000","sao paulo", "SP","brasil" ));
        hotelRepository.save( new HotelDomain("Menoti", "teste", "000","sao paulo", "SP","brasil" ));


    }

    @Test
    public void getAllHotels() {
        List<HotelDomain> hoteis = hotelRepository.findAll();

        long quantidadeRegistros = hotelRepository.count();

        assertEquals(quantidadeRegistros, hoteis.size());

    }

    @Test
    public void countOneHotel() {

        Example<HotelDomain> example = Example.of(new HotelDomain("Walter", "teste", "000","sao paulo", "SP","brasil"));

        assertThat(hotelRepository.count(example)).isEqualTo(1L);
    }

    @Test
    public void findOneHotel() {

        Example<HotelDomain> example = Example.of(new HotelDomain("Walter", "teste", "000","sao paulo", "SP","brasil"));

        Optional<HotelDomain> hotel = hotelRepository.findOne(example);
        assertThat(hotel.get().getNome()).isEqualTo("Walter");
    }



}
