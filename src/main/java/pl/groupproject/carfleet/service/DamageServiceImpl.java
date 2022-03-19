package pl.groupproject.carfleet.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.groupproject.carfleet.dto.DamageDto;
import pl.groupproject.carfleet.model.Damage;
import pl.groupproject.carfleet.repository.CarRepository;
import pl.groupproject.carfleet.repository.DamageRepository;

@Service
@RequiredArgsConstructor
public class DamageServiceImpl implements DamageService {

    private final DamageRepository damageRepository;
    private final CarRepository carRepository;

    @Override
    //moe Damage a DamageDto
    public List<Damage> getAll() {
        return damageRepository.findAll();
    }

    @Override
    public void addDamages(DamageDto carsDamage) {
        Damage damage = Damage.builder()
                .damageType(carsDamage.getDamageType())
                .description(carsDamage.getDescription())
                .drivable(carsDamage.isDrivable())
                // ifPresent()
                .car(carRepository.findById(carsDamage.getCarId()).get())
                .build();
        damageRepository.save(damage);
    }

    @Override
    public void save(Damage damage) {
        //builder i mapper zamiast set()
        damage.setDamageType(damage.getDamageType());
        damage.setDescription(damage.getDescription());
        damage.setDrivable(damage.getDrivable());
        damageRepository.save(damage);

    }


    @Override
    public void makeRepair(String id) {
        Optional<Damage> byId = damageRepository.findById(Long.valueOf(id));
        //owrapowac ifPresent przed wywolaniem metody get() z opetional
        Damage damage = byId.get();

        if (isNotDrivable(damage)) {
            damage.setDrivable(isNotDrivable(damage));
        }
        damageRepository.save(damage);
    }

    private boolean isNotDrivable(Damage damage) {
        return !damage.isDrivable();
    }

}
