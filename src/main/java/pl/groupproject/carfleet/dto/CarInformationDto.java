package pl.groupproject.carfleet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CarInformationDto {
    private Long id;
    private String carBrand;
    private String carModel;
    private String initialMileage;
    private String finaleMileage;
    //vinNumber
    private String vinNr;
    private int amountOfFuel;
    //do przechowywania walut korzystamy z BigDecimal, nigdy double. Ewentualnie mozna korzystac z int, Int,
}
