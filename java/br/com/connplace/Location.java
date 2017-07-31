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
}
