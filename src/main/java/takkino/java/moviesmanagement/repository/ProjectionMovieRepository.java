package takkino.java.moviesmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import takkino.java.moviesmanagement.entity.ProjectionMovie;

public interface ProjectionMovieRepository extends JpaRepository<ProjectionMovie, Long> {

}
