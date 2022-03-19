package pl.groupproject.carfleet.service;

import java.util.List;
import pl.groupproject.carfleet.model.Driver;

//zbedny interface
public interface DriverService {

    void save(Driver driver);

    Driver findByLogin(String login);

    String changeEmail(Long id, String newEmail);

    List<Driver> getAll();
}
