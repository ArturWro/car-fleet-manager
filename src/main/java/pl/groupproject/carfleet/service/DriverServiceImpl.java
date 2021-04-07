package pl.groupproject.carfleet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.groupproject.carfleet.model.Departure;
import pl.groupproject.carfleet.model.Driver;
import pl.groupproject.carfleet.repository.DriverRepository;
import pl.groupproject.carfleet.repository.RoleRepository;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Driver driver) {
        driver.setPassword(bCryptPasswordEncoder.encode(driver.getPassword()));
        driver.setRoles(new HashSet<>(roleRepository.findAll()));
        driverRepository.save(driver);
    }

    @Override
    public Driver findByLogin(String login) {
        return driverRepository.findByLogin(login);
    }

    @Override
    public String changeEmail(Long id, String newEmail) {
        return null;
    }

    @Override
    public List<Driver> getAll() {
        return driverRepository.findAll();
    }


}