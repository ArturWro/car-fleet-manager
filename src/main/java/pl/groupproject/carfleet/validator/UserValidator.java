package pl.groupproject.carfleet.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.groupproject.carfleet.model.Driver;
import pl.groupproject.carfleet.service.DriverService;


@Component
public class UserValidator implements Validator {

    @Autowired
    private DriverService driverService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Driver.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Driver driver = (Driver) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty");
        if (driver.getLogin().length() < 3 || driver.getLogin().length() > 32){
            errors.rejectValue("login", "Size.driverForm.login");
        }
        if (driverService.findByLogin(driver.getLogin()) != null){
            errors.rejectValue("login", "Duplicate.driverForm.login");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "NotEmpty");
        if (driver.getPassword().length() < 8 || driver.getPassword().length() > 32){
            errors.rejectValue("password", "Size.driverForm.password");
        }
        if (!driver.getPasswordConfirm().equals(driver.getPassword())){
            errors.rejectValue("passwordConfirm","Diff.driverForm.passwordConfirm");
        }
    }
}