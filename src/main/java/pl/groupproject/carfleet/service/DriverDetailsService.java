package pl.groupproject.carfleet.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface DriverDetailsService {

    //roznica miedzy throws a throw
    //https://www.youtube.com/watch?v=UPWkpl5PL_w&t=2072s
    //poczytac na jakiej metodzie mozemy zastsowac @Transactional
    UserDetails loadDriverByLogin(String login);
}
