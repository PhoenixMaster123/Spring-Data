package softuni.exam.util.impl;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;
import softuni.exam.util.ValidationUtil;

@Component
public class ValidationUtilImpl implements ValidationUtil {
    private final Validator validator;

    public ValidationUtilImpl() {
        try(ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
        }
    }
    @Override
    public <E> boolean isValid(E entity) {
        return validator.validate(entity).isEmpty(); // checks if there are no validation errors
    }
}
