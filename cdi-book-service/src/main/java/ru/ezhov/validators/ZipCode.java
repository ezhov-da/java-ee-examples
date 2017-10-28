package ru.ezhov.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by rrnezh on 28.10.2017.
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {ZipCodeValidator.class}
)
public @interface ZipCode {
    String message() default "{ru.ezhov.validators.error.zipcode.validator}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
