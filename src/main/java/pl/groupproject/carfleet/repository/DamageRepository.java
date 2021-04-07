package pl.groupproject.carfleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.groupproject.carfleet.model.Damage;

@Repository
public interface DamageRepository extends JpaRepository<Damage, Long> {

    Damage findById(String login);

}
