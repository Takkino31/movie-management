package takkino.java.moviesmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import takkino.java.moviesmanagement.entity.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
