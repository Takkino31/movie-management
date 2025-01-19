package takkino.java.moviesmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ticket {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientName;
    private double price;
//    @Column(unique = true)
    private int payementCode;
    private boolean paid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPayementCode() {
        return payementCode;
    }

    public void setPayementCode(int payementCode) {
        this.payementCode = payementCode;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @ManyToOne
    private Place place;

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @ManyToOne
    private ProjectionMovie projectionMovie;

    public ProjectionMovie getProjectionMovie() {
        return projectionMovie;
    }
    public void setProjectionMovie(ProjectionMovie projectionMovie) {
        this.projectionMovie = projectionMovie;
    }
}
