package pl.groupproject.carfleet.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.groupproject.carfleet.dto.DamageDto;
import pl.groupproject.carfleet.dto.DamageTypeDto;
import pl.groupproject.carfleet.model.Damage;
import pl.groupproject.carfleet.model.DamageType;
import pl.groupproject.carfleet.service.CarService;
import pl.groupproject.carfleet.service.DamageService;

@RestController("/api/v1/damage")
@RequiredArgsConstructor
public class DamageController {

    private final DamageService damageService;
    private final CarService carService;

    //metoda nie moze byc typu @Get jezeli cos tworzy albo edytuje
    // zweryfikuj co robi metoda i ustaw poprawny sufix do metody w controller
    @GetMapping("/cars-with-demages")
    ModelAndView createAddDamageView() {
        ModelAndView modelAndView = new ModelAndView("adddamage");
        modelAndView.addObject("damage", new DamageDto());
        modelAndView.addObject("damageTypes",
                Arrays.stream(DamageType.values())
                        .map(val -> new DamageTypeDto(val, val.getLabel()))
                        .collect(Collectors.toSet()));
        //logika jakakolwiek z controllera znika, cala logika ma siedziec w service

        // obejrz sobie prezentacje Kubrynski na yt JPA
        // roznica miedzy List i Set na blache wykuc
        // w javie w wiekszosci przypadkow uzywamy Set<T> a nie List<T>
        modelAndView.addObject("cars", carService.getAllForSelect());
        return modelAndView;
    }

    @PostMapping("/add-damage")
    public String registration(@ModelAttribute("damage") DamageDto carsDamage) {
        damageService.addDamages(carsDamage);

        return "redirect:/damages";
    }

    //najczesciej zwracamy w controller i servisie DTO a nie cala encje
    @GetMapping
    public String damages(Model model) {
        List<Damage> damages = damageService.getAll();
        model.addAttribute("damagesList", damages);
        return "damages";
    }

    @PostMapping
    public String repair(HttpServletRequest request) {
        String id = request.getParameter("msg");
        damageService.makeRepair(id);
        return "redirect:/damages";
    }

    //open api albo swagger i skorzystac z adnotacji do sprawdzenia @Api


}
