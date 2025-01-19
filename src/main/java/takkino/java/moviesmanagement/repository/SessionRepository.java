package takkino.java.moviesmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import takkino.java.moviesmanagement.entity.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
