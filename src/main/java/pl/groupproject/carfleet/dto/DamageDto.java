package pl.groupproject.carfleet.dto;

import lombok.*;
import pl.groupproject.carfleet.model.DamageType;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DamageDto {
    private Long damageId;
    private Long carId;
    private DamageType damageType;
    private String description;
    private boolean drivable;
}
