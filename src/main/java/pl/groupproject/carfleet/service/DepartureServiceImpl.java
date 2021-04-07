package pl.groupproject.carfleet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.groupproject.carfleet.model.Departure;
import pl.groupproject.carfleet.repository.DepartureRepository;

import java.util.List;


@RequiredArgsConstructor
@Service
public class DepartureServiceImpl implements DepartureService {


    private final DepartureRepository departureRepository;

    @Override
    public void save(Departure departure) {
        departureRepository.save(departure);
    }


    @Override
    public Departure findByDepFrom(String depFrom) {
        return departureRepository.findByDepFrom(depFrom);
    }


    public List<Departure> getAll(){
        return departureRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        departureRepository.deleteDepartureById(id);
    }
}