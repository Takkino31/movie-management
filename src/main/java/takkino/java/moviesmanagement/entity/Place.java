package takkino.java.moviesmanagement.entity;

import jakarta.persistence.*;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long placeId;
    private String placeNumero;
    private String latitude, longitude, altitude;

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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
