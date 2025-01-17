package takkino.java.moviesmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import takkino.java.moviesmanagement.services.ICinemaInitService;

@SpringBootApplication
public class MoviesManagementApplication implements CommandLineRunner{
	private final ICinemaInitService iCinemaInitService;

	public MoviesManagementApplication(ICinemaInitService iCinemaInitService) {
		this.iCinemaInitService = iCinemaInitService;
	}

	public static void main(String[] args) {
		SpringApplication.run(MoviesManagementApplication.class, args);
		System.out.println("MoviesManagement Application started");
		System.out.println("http://localhost:9090/h2-console");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("MoviesManagement Application started");
		iCinemaInitService.initCities();
		iCinemaInitService.initCinemas();
		iCinemaInitService.initRooms();
		iCinemaInitService.initPlaces();
		System.out.println("Takkino started his application at 9090");
	}

}
