package ru.ezhov.cdi;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by rrnezh on 28.10.2017.
 */
public class ContainsCharValidator implements ConstraintValidator<ContainsChar, String> {
    private String charValue;

    public void initialize(ContainsChar containsChar) {
        charValue = containsChar.checkChar();
    }

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.contains(charValue);
    }
}
