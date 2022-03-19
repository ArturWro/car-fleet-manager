package pl.groupproject.carfleet.model;

import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String login;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String pesel;
    private String jobTitle;
    @Getter
    private String passwordConfirm;

    //adnotacja @Embebded i @Embedable poczytac co to robi i dlaczego
    //@Embedded private Car car;

    @ManyToMany //c*
    @JoinTable(
            name = "cars_drivers",
            joinColumns = @JoinColumn(name = "driver_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    private List<Car> cars;


    //sprobujmy wrocic do @OneToMany i @ManyToOne
    //    @OneToMany(mappedBy = "drivers")
//    private Set<Departure> departures;
    @ManyToOne
    @JoinColumn(name = "departures_id")
    private Departure departures;

    //    @OneToMany(mappedBy = "drivers")
//    private Set<Damage> damages;
    @ManyToOne
    @JoinColumn(name = "damages_id")
    private Damage damages;

    @ManyToMany
    @JoinTable(name = "drivers_roles",
            joinColumns = @JoinColumn(name = "driver_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
