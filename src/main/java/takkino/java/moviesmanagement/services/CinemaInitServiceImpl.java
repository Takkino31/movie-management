package takkino.java.moviesmanagement.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import takkino.java.moviesmanagement.entity.Cinema;
import takkino.java.moviesmanagement.entity.City;
import takkino.java.moviesmanagement.entity.Place;
import takkino.java.moviesmanagement.entity.Room;
import takkino.java.moviesmanagement.repository.CinemaRepository;
import takkino.java.moviesmanagement.repository.CityRepository;
import takkino.java.moviesmanagement.repository.PlaceRepository;
import takkino.java.moviesmanagement.repository.RoomRepository;

import java.util.stream.Stream;

@Service
@Transactional
public class CinemaInitServiceImpl implements ICinemaInitService{
    private final CinemaRepository cinemaRepository;
    private final CityRepository cityRepository;
    private final RoomRepository roomRepository;
    private final PlaceRepository placeRepository;

    public CinemaInitServiceImpl(CinemaRepository cinemaRepository, CityRepository cityRepository, RoomRepository roomRepository, PlaceRepository placeRepository) {
        this.cinemaRepository = cinemaRepository;
        this.cityRepository = cityRepository;
        this.roomRepository = roomRepository;
        this.placeRepository = placeRepository;
    }

    @Override
    public void initCities() {
        Stream.of("Saint-Louis","Dakar","Paris","London","")
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
                System.out.println("ADDING de place n"+ (i+1) + room.getCinema().getCinemaName());
                Place place = new Place();
                place.setPlaceNumero(String.valueOf(i+1));
                place.setRoom(room);
                placeRepository.save(place);
            }
        });
    }
}
