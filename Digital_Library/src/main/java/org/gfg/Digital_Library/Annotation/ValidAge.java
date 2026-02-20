package org.gfg.Digital_Library.Annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StudentAgeValidation.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAge {

    String message() default "Age should not be less than 18";

    int age() default 18;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
