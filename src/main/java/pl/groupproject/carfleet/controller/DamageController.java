package pl.groupproject.carfleet.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.groupproject.carfleet.dto.CarInformationDto;
import pl.groupproject.carfleet.dto.DamageDto;
import pl.groupproject.carfleet.dto.DamageTypeDto;
import pl.groupproject.carfleet.model.Damage;
import pl.groupproject.carfleet.model.DamageType;
import pl.groupproject.carfleet.service.CarService;
import pl.groupproject.carfleet.service.DamageService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class DamageController {

    private final DamageService damageService;
    private final CarService carService;

    @GetMapping("/adddamage")
    ModelAndView createAddDamageView() {
        ModelAndView modelAndView = new ModelAndView("adddamage");
        modelAndView.addObject("damage", new DamageDto());
        modelAndView.addObject("damageTypes",
                Arrays.stream(DamageType.values())
                        .map(val -> new DamageTypeDto(val, val.getLabel()))
                        .collect(Collectors.toList()));
        modelAndView.addObject("cars", carService.getAllForSelect());
        return modelAndView;
    }

    @PostMapping("/adddamage")
    public String registration(@ModelAttribute("damage") DamageDto carsDamage, BindingResult bindingResult) {
        damageService.addDamages(carsDamage);

        return "redirect:/damages";
    }

    @GetMapping("/damages")
    public String damages(Model model) {
        List<Damage> damages = damageService.getAll();
        model.addAttribute("damagesList", damages);
        return "damages";
    }

    @PostMapping("/damages")
    public String repair(HttpServletRequest request) {
        String id = request.getParameter("msg");
        damageService.makeRepair(id);
        return "redirect:/damages";
    }


    //dodawanie, usuwanie, lista, wyszukiwanie, usuwanie jednego po id_car czy damage, usuwanie wszystkich

}