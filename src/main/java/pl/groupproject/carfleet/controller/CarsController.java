package pl.groupproject.carfleet.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.groupproject.carfleet.dto.CarInformationDto;
import pl.groupproject.carfleet.dto.CarsDto;
import pl.groupproject.carfleet.service.CarService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CarsController {

    private final CarService service;


    @GetMapping("/cars")
    public String allCars(Model model) {
        List<CarsDto> cars = service.getAll();
        model.addAttribute("carslist", cars);
        return "cars";
    }

    @GetMapping("/addcar")
    ModelAndView createAddCarView() {
        ModelAndView modelAndView = new ModelAndView("addcar");
        modelAndView.addObject("car", new CarInformationDto());
        return modelAndView;
    }

    @GetMapping("/editcar/{id}")
    ModelAndView editCarView(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("addcar");
        modelAndView.addObject("car", service.getInformationAboutCar(id));
        return modelAndView;
    }

    @PostMapping(value = {"/addcar", "/editcar/**"})
    public String registration(@ModelAttribute("car") CarInformationDto carForm) {
        service.createOrUpdateCar(carForm);

        return "redirect:/cars";
    }


    @PostMapping("/cars")
    public String reservation(HttpServletRequest request) {
        String parameter = request.getParameter("msg");
        service.makeReservation(parameter);
        System.out.println(parameter);

        return "redirect:/cars";
    }

    @GetMapping("/cars/delete/{id}")
    public String delete(@PathVariable Long id){
        service.deleteCar(id);
        return "redirect:/cars";
    }

//    @PostMapping("/cars")
//    public String carUpdate(HttpServletRequest request){
//        String parameter = request.getParameter("update");
//        service.updateCar(parameter);
//        System.out.println(parameter);
//
//        return "redirect:/cars";
//    }
//    @PostMapping("/cars")
//    public String carUpdate(@ModelAttribute("car") CarsDto carForm){
//        service.updateCar(carForm.getUpdate());
//
//        return "redirect:/cars";
//    }


}
