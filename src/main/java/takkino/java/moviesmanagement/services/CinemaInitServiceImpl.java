package takkino.java.moviesmanagement.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import takkino.java.moviesmanagement.entity.*;
import takkino.java.moviesmanagement.repository.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
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
    private final SessionRepository sessionRepository;
    private final ProjectionMovieRepository projectionMovieRepository;
    private final TicketRepository ticketRepository;

    public CinemaInitServiceImpl(CinemaRepository cinemaRepository, CityRepository cityRepository, RoomRepository roomRepository, PlaceRepository placeRepository, CategoryRepository categoryRepository, MovieRepository movieRepository,SessionRepository sessionRepository, ProjectionMovieRepository projectionMovieRepository, TicketRepository ticketRepository) {
        this.cinemaRepository = cinemaRepository;
        this.cityRepository = cityRepository;
        this.roomRepository = roomRepository;
        this.placeRepository = placeRepository;
        this.categoryRepository = categoryRepository;
        this.movieRepository = movieRepository;
        this.sessionRepository = sessionRepository;
        this.ticketRepository = ticketRepository;
        this.projectionMovieRepository = projectionMovieRepository;
    }

    @Override
    public void initCities() {
        Stream.of("Saint-Louis","Dakar","Paris","London","Miami")
            .forEach(name -> {
                System.out.println("Initializing City: " + name);
                City city = new City();
                city.setName(name);
                city.setLatitude(3+(int)(Math.random()*2));
                city.setLongitude(2+(int)(Math.random()*2));
                city.setAltitude(4+(int)(Math.random()*2));
                cityRepository.save(city);
            }
        );
    }

    @Override
    public void initCinemas() {
        cityRepository.findAll().forEach(city -> Stream.of("Pathe","SEA PLAZA", "RP","Wembley","Spurnabeu").forEach(name -> {
            System.out.println("Initializing Cinema: " + name);
            Cinema cinema = new Cinema();
            cinema.setCinemaName(name);
            cinema.setLatitude(3+(int)(Math.random()*2));
            cinema.setLongitude(2+(int)(Math.random()*2));
            cinema.setAltitude(4+(int)(Math.random()*2));
            cinema.setNumberOfRooms(3+(int)(Math.random()*3));
            cinema.setCity(city);
            cinemaRepository.save(cinema);
        }));
    }

    @Override
    public void initRooms() {
        cinemaRepository.findAll().forEach(cinema -> {
            for (int i = 0; i < cinema.getNumberOfRooms(); i++) {
                System.out.println("Initializing room: " + (i+1));
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
                System.out.println("Initializing place: " + (i+1));
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
                System.out.println("Initializing Category: " + name);
                Category category = new Category();
                category.setName(name);
                categoryRepository.save(category);
            }
        );
    }

    @Override
    public void initMovies() {
        categoryRepository.findAll().forEach(category -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Initializing Movie: " + (i+1));
                Movie movie = new Movie();
                movie.setDateProjection(new Date());
                movie.setTitle("Film "+ (i+1));
                movie.setCategory(category);
                movieRepository.save(movie);
            }
        });
    }

    @Override
    public void initSessions() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Stream.of("12:00","15:00","17:00","19:00","21:00")
            .forEach(time -> {
                System.out.println("Initializing Session: " + (time));
                Session session = new Session();
                try {
                    session.setStartTime(dateFormat.parse(time));
                    sessionRepository.save(session);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    @Override
    public void initProjectionsMovies() {
        double [] prices = new double []{1000,20000,5000,10000,50000};
        cityRepository.findAll().forEach(city -> {
            city.getCinemas().forEach(cinema -> {
                cinema.getRooms().forEach(room -> {
                    movieRepository.findAll().forEach(movie -> {
                        sessionRepository.findAll().forEach(session -> {
                            System.out.println("Initializing Projection: " + movie.getTitle() + " " + session.getStartTime());
                            ProjectionMovie projection = new ProjectionMovie();
                            projection.setDateProjection(new Date());
                            projection.setMovie(movie);
                            projection.setPrice(prices[new Random().nextInt(prices.length)]);
                            projection.setRoom(room);
                            projection.setSession(session);
                            projectionMovieRepository.save(projection);
                        });
                    });
                });
            });
        });
    }

    @Override
    public void initTickets(){
        projectionMovieRepository.findAll().forEach(projectionMovie -> {
            projectionMovie.getRoom().getPlaces().forEach(place -> {
                System.out.println("Initializing Ticket : " + place.getPlaceNumero() + " " + place.getRoom().getName());
                Ticket ticket = new Ticket();
               ticket.setPlace(place);
               ticket.setPrice(projectionMovie.getPrice());
               ticket.setProjectionMovie(projectionMovie);
               ticket.setPaid(false);
               ticketRepository.save(ticket);
            });
        });
    }
}
