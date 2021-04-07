package pl.groupproject.carfleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.groupproject.carfleet.model.Departure;

@Repository
public interface DepartureRepository extends JpaRepository<Departure, Long> {

    Departure findByDepFrom(String depFrom);

    void deleteDepartureById(Long id);
}
