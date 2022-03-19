package pl.groupproject.carfleet.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.groupproject.carfleet.model.Driver;
import pl.groupproject.carfleet.security.SecurityService;
import pl.groupproject.carfleet.service.DriverService;
import pl.groupproject.carfleet.validator.EmailValidator;
import pl.groupproject.carfleet.validator.UserValidator;
import pl.groupproject.carfleet.validator.Validator;

@RestController("/api/v1/driver")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;
    private final SecurityService securityService;
    private final UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("driverForm", new Driver());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("driverForm") Driver driverForm, BindingResult bindingResult) {
        Validator.validate(new EmailValidator(), driverForm);
        userValidator.validate(driverForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/registration";
        }
        driverService.save(driverForm);

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "/login";
    }

    @RequestMapping("/welcome")
    public String welcome(Model model) {
        return "/welcome";
    }

    public SecurityService getSecurityService() {
        return securityService;
    }

    @PutMapping("/driverslist/newemail")
    public String changeEmail(@PathVariable Long id, @RequestBody String newEmail) {
        return driverService.changeEmail(id, newEmail);
    }
    @GetMapping("/driverslist/newemail")
    public String newMail(Model model){
        return "driverslist/newemail";
    }

    @RequestMapping("/driverslist")
    public String allDrivers(Model model) {
        List<Driver> driverList = driverService.getAll();
        model.addAttribute("driverForm", driverList);
        return "driverslist";
    }

}
