package takkino.java.moviesmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import takkino.java.moviesmanagement.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

}
