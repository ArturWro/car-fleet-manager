package pl.groupproject.carfleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.groupproject.carfleet.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Driver findByLogin(String login);

}