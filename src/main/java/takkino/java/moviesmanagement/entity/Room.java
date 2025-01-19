package takkino.java.moviesmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Collection;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int numberOfSeats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @OneToMany(mappedBy = "room")
    private Collection<Place> places;

    public Collection<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Collection<Place> places) {
        this.places = places;
    }

//    @ManyToMany
//    private Collection<Movie> movies;
//
//    public Collection<Movie> getMovies() {
//        return movies;
//    }
//
//    public void setMovies(Collection<Movie> movies) {
//        this.movies = movies;
//    }

//    @OneToMany(mappedBy = "roomProjection")
//    private Collection<Projection> projections;
//
//    public Collection<Projection> getProjections() {
//        return projections;
//    }
//
//    public void setProjections(Collection<Projection> projections) {
//        this.projections = projections;
//    }
}
