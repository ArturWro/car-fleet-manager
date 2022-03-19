package pl.groupproject.carfleet.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Entity
@Table (name = "damages")
@EntityListeners(AuditingEntityListener.class)
//@Builder(setterPrefix = "with")
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
