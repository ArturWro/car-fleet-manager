package pl.groupproject.carfleet.model;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import pl.groupproject.carfleet.service.CarService;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table (name = "damages")
@EntityListeners(AuditingEntityListener.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Damage {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private DamageType damageType;
    private String description;
    @Column(name = "can_be_used")
    private boolean drivable=false;

    @ManyToMany(mappedBy = "damages")
    private Set<Departure> departures;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @OneToMany(mappedBy = "damages")
    private Set<Driver> drivers;

    public boolean isDrivable() { return drivable;
    }

    public boolean getDrivable() {
        return drivable;
    }
}
