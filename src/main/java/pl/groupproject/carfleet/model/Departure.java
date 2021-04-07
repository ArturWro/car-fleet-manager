package pl.groupproject.carfleet.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.DomainCombiner;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "departures")
public class Departure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String depFrom;
    private String depTo;
    private int distance;

    @ManyToMany
    @JoinTable(
            name = "departures_damages",
            joinColumns = @JoinColumn(name = "departure_id"),
            inverseJoinColumns = @JoinColumn(name = "damage_id"))
    private List<Damage> damages;


    @OneToMany(mappedBy = "departures")
    private List<Driver> drivers;


    @OneToMany(mappedBy = "departures")
    private List<Car> cars;
}