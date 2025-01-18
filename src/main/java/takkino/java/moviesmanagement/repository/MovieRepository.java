package takkino.java.moviesmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import takkino.java.moviesmanagement.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
