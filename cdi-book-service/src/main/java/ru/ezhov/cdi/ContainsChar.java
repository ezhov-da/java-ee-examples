package ru.ezhov.cdi;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, ANNOTATION_TYPE, CONSTRUCTOR, FIELD})
@Constraint(validatedBy = ContainsCharValidator.class)
public @interface ContainsChar {
    String message() default "{ru.ezhov.cdi.ContainsChar.message}"; //указывается абсолютный путь к аннотации валидации + поле сообщения

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    //Собственный метод
    String checkChar();
}
