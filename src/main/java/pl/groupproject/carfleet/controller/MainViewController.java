package pl.groupproject.carfleet.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.groupproject.carfleet.model.Driver;
import pl.groupproject.carfleet.service.DriverDetailsService;

@Controller
public class MainViewController {

    @RequestMapping
    ModelAndView mainView(){
        ModelAndView modelAndView = new ModelAndView("/main");

//        DriverDetailsService userDetails = (DriverDetailsService) SecurityContextHolder.getContext()
//                .getAuthentication().getPrincipal();
//        //String imieZalogowanego = userDetails.getClass(Driver.class());

        return modelAndView;
    }
}
