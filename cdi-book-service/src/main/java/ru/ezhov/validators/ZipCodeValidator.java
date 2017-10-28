package ru.ezhov.validators;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rrnezh on 28.10.2017.
 */
public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {
    @Inject
    @USA
    private ZipCodeChecker checker;

    private Pattern pattern = Pattern.compile("\\d{5}(-\\d{5})?");

    @Override
    public void initialize(ZipCode constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return true;
        }

        Matcher matcher = pattern.matcher(s);
        if (!matcher.matches()) {
            return false;
        }

        return checker.isZipCodeValid(s);
    }
}
