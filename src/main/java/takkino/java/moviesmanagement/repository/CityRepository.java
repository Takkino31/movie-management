package takkino.java.moviesmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import takkino.java.moviesmanagement.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {
}
