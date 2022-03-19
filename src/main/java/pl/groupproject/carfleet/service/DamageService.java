package pl.groupproject.carfleet.service;

import java.util.List;
import pl.groupproject.carfleet.dto.DamageDto;
import pl.groupproject.carfleet.model.Damage;

//zbedny interfejs a same metody wolac w DamageService
public interface DamageService {

    List<Damage> getAll();

    void addDamages(DamageDto carsDamage);

    void save(Damage damageList);

    void makeRepair(String id);


}
