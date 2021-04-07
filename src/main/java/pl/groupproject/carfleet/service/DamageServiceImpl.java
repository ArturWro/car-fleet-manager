package pl.groupproject.carfleet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.groupproject.carfleet.dto.DamageDto;
import pl.groupproject.carfleet.model.Damage;
import pl.groupproject.carfleet.repository.CarRepository;
import pl.groupproject.carfleet.repository.DamageRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DamageServiceImpl implements DamageService {

    private final DamageRepository damageRepository;
    private final CarRepository carRepository;

    @Override
    public List<Damage> getAll() {
        return damageRepository.findAll();
    }

    @Override
    public void addDamages(DamageDto carsDamage) {
        Damage damage = Damage.builder()
                .damageType(carsDamage.getDamageType())
                .description(carsDamage.getDescription())
                .drivable(carsDamage.isDrivable())
                .car(carRepository.findById(carsDamage.getCarId()).get())
                .build();
        damageRepository.save(damage);
    }

    @Override
    public void save(Damage damageList) {
        damageList.setDamageType(damageList.getDamageType());
        damageList.setDescription(damageList.getDescription());
        damageList.setDrivable(damageList.getDrivable());
        damageRepository.save(damageList);

    }


    @Override
    public void makeRepair(String id) {
        Optional<Damage> byId = damageRepository.findById(Long.valueOf(String.valueOf(id)));
        Damage damage = byId.get();

        if (damage.isDrivable() == false) {
            damage.setDrivable(!damage.isDrivable());
        }
        damageRepository.save(damage);
    }

}
