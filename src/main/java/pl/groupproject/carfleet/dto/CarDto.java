package pl.groupproject.carfleet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CarDto {
    private Long id;
    private String carBrand;
    private String carModel;
    private String vinNr;
    private boolean reservation;
    private String update;
    private String deleteCar;
    private String initialMileage;
    private String finaleMileage;
    private int amountOfFuel;
}
