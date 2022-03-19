package pl.groupproject.carfleet.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.groupproject.carfleet.dto.CarDto;
import pl.groupproject.carfleet.dto.CarInformationDto;
import pl.groupproject.carfleet.service.CarService;

@RestController("/api/v1/cars")
@RequiredArgsConstructor
@Slf4j
public class CarsController {

    public static final String REDIRECT_CARS = "redirect:/cars";
    private final CarService service;

    //instalujemy dodatek do IDE sonar lint

    //wszystkie metody controllera zawsze public
    // poczytac dlaczego nie zwracamy Stringa jako typu
    @GetMapping
    public String allCars(Model model) {
        List<CarDto> cars = service.getAll();
        model.addAttribute("carslist", cars);
        return "cars";
    }

    //zamieniamy na ResponseEntity bez ModelAndView
    //odchodzimy od cammelCase tylko parametr jako param-param
    @GetMapping("/add-car")
    ModelAndView createAddCarView() {
        ModelAndView modelAndView = new ModelAndView("addcar");
        modelAndView.addObject("car", CarInformationDto.builder().build());
        //
        CarInformationDto.builder()
            .withVinNr("12345")
            .withId(1L)
            .withCarBrand("BRAND")
            .build();
        return modelAndView;
    }

    @GetMapping("/editcar/{id}")
    ModelAndView editCarView(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("addcar");
        modelAndView.addObject("car", service.getInformationAboutCar(id));
        return modelAndView;
    }

    //rozdzielamy na dwa endpointy add-car i endpoint edit-car
    @PostMapping(value = {"/addcar", "/editcar/**"})
    public String registration(@ModelAttribute("car") CarInformationDto carForm) {
        return service.createCar(carForm);
    }


    @PostMapping("/cars")
    public String reservation(HttpServletRequest request) {
        String parameter = request.getParameter("msg");
        service.makeReservation(parameter);
        log.info(parameter);

        return REDIRECT_CARS;
    }

    @GetMapping("/cars/delete/{id}")
    public String delete(@PathVariable Long id){
        service.deleteCar(id);
        return REDIRECT_CARS;
    }


}
