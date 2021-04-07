package pl.groupproject.carfleet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CarsDto {
    private Long id;
    private String carBrand;
    private String carModel;
    private String vinNr;
    private boolean reservation;
    private String update;
    private String deleteCar;
}
