package pl.groupproject.carfleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.groupproject.carfleet.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}