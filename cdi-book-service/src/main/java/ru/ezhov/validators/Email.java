package ru.ezhov.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;

/**
 * Created by rrnezh on 28.10.2017.
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ReportAsSingleViolation
@Pattern(regexp = "[A-Za-z]+@[A-Za-z]+\\.[A-Za-z]+")
@Constraint(
        validatedBy = {}
)
public @interface Email {
    String message() default "{ru.ezhov.validators.error.email.validator.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
