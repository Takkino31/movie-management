package takkino.java.moviesmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviesManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesManagementApplication.class, args);
		System.out.println("MoviesManagement Application started");
		System.out.println("http://localhost:9090/h2-console");
	}

}
