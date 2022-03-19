package pl.groupproject.carfleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.groupproject.carfleet.model.Car;

@Repository
//zbedne repo na te chwile bo metoda nie uzyta
public interface CarRepository extends JpaRepository<Car, Long> {
    void deleteCarById(Long id);
}
