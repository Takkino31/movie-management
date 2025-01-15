package takkino.java.moviesmanagement.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import takkino.java.moviesmanagement.entity.Cinema;
import takkino.java.moviesmanagement.entity.City;
import takkino.java.moviesmanagement.repository.CinemaRepository;
import takkino.java.moviesmanagement.repository.CityRepository;

import java.util.stream.Stream;

@Service
@Transactional
public class CinemaInitServiceImpl implements ICinemaInitService{
    private final CinemaRepository cinemaRepository;
    private final CityRepository cityRepository;

    public CinemaInitServiceImpl(CinemaRepository cinemaRepository, CityRepository cityRepository) {
        this.cinemaRepository = cinemaRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public void initCity() {
        Stream.of("Saint-Louis","Dakar","Paris","London","")
            .forEach(name -> {
                City city = new City();
                city.setName(name);
                cityRepository.save(city);
            }
        );
    }
    @Override
    public void initCinema() {
        cityRepository.findAll().forEach(city -> Stream.of("Pathe","SEA PLAZA", "RP","Wembley","Spurnabeu").forEach(name -> {
            Cinema cinema = new Cinema();
            cinema.setCinemaName(name);
            cinema.setLatitude(3+(int)(Math.random()*2));
            cinema.setLongitude(2+(int)(Math.random()*2));
            cinema.setAltitude(4+(int)(Math.random()*2));
            cinema.setNumberOfSeats(3+(int)(Math.random()*100));
            cinema.setCity(city);
            cinemaRepository.save(cinema);
        }));
    }
}
