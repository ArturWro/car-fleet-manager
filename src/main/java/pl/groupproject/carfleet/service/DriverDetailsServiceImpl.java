package pl.groupproject.carfleet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.groupproject.carfleet.model.Driver;
import pl.groupproject.carfleet.model.Role;
import pl.groupproject.carfleet.repository.DriverRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class DriverDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final DriverRepository driverRepository;

    public DriverDetailsServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    @Transactional (readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Driver driver = driverRepository.findByLogin(login);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : driver.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_DRIVER"));

        return new org.springframework.security.core.userdetails
                .User(driver.getLogin(), driver.getPassword(), grantedAuthorities);

    }
}
