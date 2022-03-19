package pl.groupproject.carfleet.validator;

import static org.apache.logging.log4j.util.Strings.isBlank;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class EmailValidator implements Validator<String> {

  private static final String EMAIL_VALIDATION_EXCEPTION =  "Email validation exception";
  private static final Pattern EMAIL_REGEX = Pattern.compile("^.+@.+\\..+$");

  @Override
  public Map<String, String> validate(String email) {
    Map<String, String> errors = new HashMap<>();

    //zobaczyc z ciekawosci StringUtils z zaleznosci dodanej jako ostatnia w pom.xml
    if (isBlank(email)) {
      errors.put(EMAIL_VALIDATION_EXCEPTION, "Email address cannot be blank");
    }
    if (emailDoesntMatchPatter(email)) {
      errors.put(EMAIL_VALIDATION_EXCEPTION, "Email doesn't match pattern");
    }
    return errors;
  }

  private boolean emailDoesntMatchPatter(String email) {
    return !EMAIL_REGEX.matcher(email).matches();
  }
}
