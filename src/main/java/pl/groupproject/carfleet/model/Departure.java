package pl.groupproject.carfleet.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "departures")
public class Departure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //zbedna adnotacja
    @Column(name = "id")
    private Long id;
    private String depFrom;
    private String depTo;
    private int distance;

    //sprobowac zmienic na @OneToMany albo @ManyToOne
    // + zrozumiem relacje w hibernate czym sie roznia i jak sie przechowuje ID w bazie(podpowidz tabela posredniczaca)
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
