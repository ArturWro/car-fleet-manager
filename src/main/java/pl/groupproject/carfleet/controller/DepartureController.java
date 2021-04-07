package pl.groupproject.carfleet.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.groupproject.carfleet.model.Departure;
import pl.groupproject.carfleet.repository.DepartureRepository;
import pl.groupproject.carfleet.service.DepartureService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DepartureController {


    private final DepartureService service;

    private final DepartureRepository repository;

    @GetMapping("/departure")
    public String addDeparture(Model model) {
        model.addAttribute("departureForm", new Departure());
        return "/departure";
    }

    @PostMapping("/departure")
    public String addDeparture(@ModelAttribute("departureForm") Departure departure) {

        service.save(departure);
        return "redirect:/departurelist";
    }

    @GetMapping("/departurelist")
    public String allCars(Model model) {
        List<Departure> departures = service.getAll();
        model.addAttribute("departureForm", departures);
        return "departurelist";
    }

    @GetMapping("/departurelist/delete/{id}")
    public String delete (@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/departurelist";
    }
}