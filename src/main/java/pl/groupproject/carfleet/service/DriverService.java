package pl.groupproject.carfleet.service;

import pl.groupproject.carfleet.model.Driver;

import java.util.List;

public interface DriverService {

    void save(Driver driver);

    Driver findByLogin(String login);

    String changeEmail(Long id, String newEmail);

    List<Driver> getAll();
}