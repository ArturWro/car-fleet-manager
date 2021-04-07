package pl.groupproject.carfleet.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    private String passwordConfirm;

    //@Embedded private Car car;

    @ManyToMany //c*
    @JoinTable(
            name = "cars_drivers",
            joinColumns = @JoinColumn(name = "driver_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    private List<Car> cars;


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

    public String getPasswordConfirm() {
        return passwordConfirm;
    }
}