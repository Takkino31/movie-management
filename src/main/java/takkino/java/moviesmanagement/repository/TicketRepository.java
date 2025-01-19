package takkino.java.moviesmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import takkino.java.moviesmanagement.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
