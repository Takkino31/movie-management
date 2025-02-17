package takkino.java.moviesmanagement.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long placeId;
    private String placeNumero;
    private double latitude, longitude, altitude;

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public String getPlaceNumero() {
        return placeNumero;
    }

    public void setPlaceNumero(String placeNumero) {
        this.placeNumero = placeNumero;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    @ManyToOne
    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @OneToMany (mappedBy = "place")
    private Collection<Ticket> tickets;

    public Collection<Ticket> getTickets() {
        return tickets;
    }
    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }
}
