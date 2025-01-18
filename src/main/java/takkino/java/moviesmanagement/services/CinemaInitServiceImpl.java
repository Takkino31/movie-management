package takkino.java.moviesmanagement.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import takkino.java.moviesmanagement.entity.*;
import takkino.java.moviesmanagement.repository.*;

import java.util.Date;
import java.util.stream.Stream;

@Service
@Transactional
public class CinemaInitServiceImpl implements ICinemaInitService{
    private final CinemaRepository cinemaRepository;
    private final CityRepository cityRepository;
    private final RoomRepository roomRepository;
    private final PlaceRepository placeRepository;
    private final CategoryRepository categoryRepository;
    private final MovieRepository movieRepository;

    public CinemaInitServiceImpl(CinemaRepository cinemaRepository, CityRepository cityRepository, RoomRepository roomRepository, PlaceRepository placeRepository, CategoryRepository categoryRepository, MovieRepository movieRepository) {
        this.cinemaRepository = cinemaRepository;
        this.cityRepository = cityRepository;
        this.roomRepository = roomRepository;
        this.placeRepository = placeRepository;
        this.categoryRepository = categoryRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public void initCities() {
        Stream.of("Saint-Louis","Dakar","Paris","London","Miami")
            .forEach(name -> {
                City city = new City();
                city.setName(name);
                cityRepository.save(city);
            }
        );
    }

    @Override
    public void initCinemas() {
        cityRepository.findAll().forEach(city -> Stream.of("Pathe","SEA PLAZA", "RP","Wembley","Spurnabeu").forEach(name -> {
            Cinema cinema = new Cinema();
            cinema.setCinemaName(name);
            cinema.setLatitude(3+(int)(Math.random()*2));
            cinema.setLongitude(2+(int)(Math.random()*2));
            cinema.setAltitude(4+(int)(Math.random()*2));
            cinema.setNumberOfRooms(3+(int)(Math.random()*100));
            cinema.setCity(city);
            cinemaRepository.save(cinema);
        }));
    }

    @Override
    public void initRooms() {
        cinemaRepository.findAll().forEach(cinema -> {
            for (int i = 0; i < cinema.getNumberOfRooms(); i++) {
                Room room = new Room();
                room.setName("Salle " + (i+1));
                room.setCinema(cinema);
                room.setNumberOfSeats(15+(int)(Math.random()*20));
                roomRepository.save(room);
            }
        });
    }

    @Override
    public void initPlaces(){
        roomRepository.findAll().forEach(room -> {
            for (int i = 0; i < room.getNumberOfSeats(); i++) {
                Place place = new Place();
                place.setPlaceNumero(String.valueOf(i+1));
                place.setLatitude(3+(int)(Math.random()*2));
                place.setLongitude(2+(int)(Math.random()*2));
                place.setAltitude(4+(int)(Math.random()*2));
                place.setRoom(room);
                placeRepository.save(place);
            }
        });
    }

    @Override
    public void initCategories() {
        Stream.of("Drama","Horreur","Amour","Passion","Comedies")
            .forEach(name -> {
                Category category = new Category();
                category.setName(name);
                categoryRepository.save(category);
            });
    }

    @Override
    public void initMovies() {
        categoryRepository.findAll().forEach(category -> {
            for (int i = 0; i < 5; i++) {
                Movie movie = new Movie();
                movie.setDateProjection(new Date());
                movie.setTitle("Film "+ (i+1));
                movie.setCategory(category);
                movieRepository.save(movie);
            }
        });
    }
}
