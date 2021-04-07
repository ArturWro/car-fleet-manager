package pl.groupproject.carfleet.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface DriverDetailsService {

    @Transactional(readOnly = true)
    UserDetails loadDriverByLogin(String login) throws UsernameNotFoundException;
}
