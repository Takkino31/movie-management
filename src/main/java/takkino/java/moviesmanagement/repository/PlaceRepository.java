package takkino.java.moviesmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import takkino.java.moviesmanagement.entity.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {

}
