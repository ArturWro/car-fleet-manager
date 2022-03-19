package pl.groupproject.carfleet.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.groupproject.carfleet.model.Departure;
import pl.groupproject.carfleet.repository.DepartureRepository;
import pl.groupproject.carfleet.service.DepartureService;

@RestController("/api/v1/departure")
@RequiredArgsConstructor
public class DepartureController {

    private static final String REDIRECT_DEPARTURE_LIST = "redirect:/departure-list";

    private final DepartureService departureService;
    private final DepartureRepository departureRepository;

    //nie zwracamy Stringa tylko valueObject z polem String, doczytac jakie jest tego uzycie
    @PostMapping("/departure")
    public String addDeparture(@ModelAttribute("departureForm") Departure departure) {

        departureService.save(departure);
        return REDIRECT_DEPARTURE_LIST;
    }

    @GetMapping
    public String allCars(Model model) {
        List<Departure> departures = departureService.getAll();
        model.addAttribute("departureForm", departures);
        return "departurelist";
    }

    @GetMapping("/delete/{id}")
    public String delete (@PathVariable Long id) {
        departureRepository.deleteById(id);
        return REDIRECT_DEPARTURE_LIST;
    }
}
