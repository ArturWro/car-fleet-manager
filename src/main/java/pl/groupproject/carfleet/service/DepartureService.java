package pl.groupproject.carfleet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.groupproject.carfleet.model.Departure;

import java.util.List;
import java.util.Optional;

@Service
public interface DepartureService {

    void save (Departure departure);

    Departure findByDepFrom(String depFrom);

    List<Departure> getAll();

    void delete(Long id);
}