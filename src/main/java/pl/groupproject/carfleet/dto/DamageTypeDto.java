package pl.groupproject.carfleet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.groupproject.carfleet.model.DamageType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DamageTypeDto {
    private DamageType type;
    private String label;
}
