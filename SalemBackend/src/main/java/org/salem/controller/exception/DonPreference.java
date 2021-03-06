package org.salem.controller.exception;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DonValidator.class)
@Documented
public @interface DonPreference {

    String message() default "Don type is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}