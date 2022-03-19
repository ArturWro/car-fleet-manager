package pl.groupproject.carfleet.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import pl.groupproject.carfleet.dto.CarDto;
import pl.groupproject.carfleet.dto.CarInformationDto;

@Entity
@Table(name = "cars")
@EntityListeners(AuditingEntityListener.class)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    //poczytac jakie sa typy generowanie ID w hibernate, co jest oprocz AUTO
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String carBrand;
    private String carModel;
    private String initialMileage;
    private String finaleMileage;
    private String vinNr;
    private int amountOfFuel;
    private boolean reservation;
    private String carUpdate;
    private String deleteCar;


    //sprobuj na testowym schemacie bazy przerobic aktualny ManyToMany na OneToMany
    @ManyToMany(mappedBy = "cars")
    private List<Driver> drivers;
    //analogicznie jak wyzej zmien na @OneToMany
    @ManyToMany
    @JoinTable(
            name = "damages_cars",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "damage_id"))
    private List<Damage> damages;
    //same
    @ManyToOne
    @JoinColumn(name = "departures_id")
    private Departure departures;

    public CarDto carsDto(){
        return CarDto.builder()
                .id(id)
                .carModel(carModel)
                .carBrand(carBrand)
                .build();
    }

    public CarInformationDto carInformationDto(){
        return CarInformationDto.builder()
                .withId(id)
                .withCarBrand(carBrand)
                .withCarModel(carModel)
                .withInitialMileage(initialMileage)
                .withFinaleMileage(finaleMileage)
                .withVinNr(vinNr)
                .withAmountOfFuel(amountOfFuel)
                .build();
    }


}
