package br.com.connplace;

import javax.persistence.*;

@Entity
@Table(name="ccp_location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_id")
    private int id;

    @Column(name = "location_latitude")
    private double latitude;

    @Column(name = "location_longitude")
    private double longitude;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private int idUser;

    public Location(){}

    public Location(int id, double latitude, double longitude, User user) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
