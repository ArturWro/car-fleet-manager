package pl.groupproject.carfleet.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder(setterPrefix = "with")
public class VinObject {

  private final String vinNumber;

}
