package pl.groupproject.carfleet.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DamageType {
  //nigdy nie uzywamy polskiego jezyka w kodzie
  ENGINE("Silnik"),
  CARSHEET("Karoseria"),
  WHEEL("Koła"),
  GLASS("Szyby");

  private final String label;

}
