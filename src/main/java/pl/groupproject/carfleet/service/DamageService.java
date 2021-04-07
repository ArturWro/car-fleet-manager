package pl.groupproject.carfleet.service;

import pl.groupproject.carfleet.dto.DamageDto;
import pl.groupproject.carfleet.model.Damage;

import java.util.List;


public interface DamageService {

    List<Damage> getAll();

    void addDamages(DamageDto carsDamage);

    void save(Damage damageList);

    void makeRepair(String id);


}
