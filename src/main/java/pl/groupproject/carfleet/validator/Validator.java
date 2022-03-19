package pl.groupproject.carfleet.validator;

import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

public interface Validator<T> {

  static <T> void validate(Validator<T> validator, T item) {
    var errors = validator.validate(item);
    if (validatorFoundErrors(errors)) {
      var message =
          errors.entrySet().stream()
              .map(e -> e.getKey() + ": " + e.getValue())
              .collect(Collectors.joining(", "));
      LOGGER.log.error("Validator found errors: {}", errors);
      throw new ValidatorException("Validator found errors: " + message);
    }
  }

  static boolean validatorFoundErrors(Map<String, String> errors) {
    return !errors.isEmpty();
  }

  Map<String, String> validate(T item);

  @Slf4j
  final class LOGGER {}
}
