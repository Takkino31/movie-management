package takkino.java.moviesmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cinema implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String cinemaId;
    private String cinemaName;
    private double longitude, latitude, altitude;
    private int numberOfRooms;
}
