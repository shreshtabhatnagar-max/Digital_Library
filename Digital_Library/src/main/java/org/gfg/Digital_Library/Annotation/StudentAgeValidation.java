package org.gfg.Digital_Library.Annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class StudentAgeValidation implements ConstraintValidator<ValidAge, String> {
    int minAge;

    @Override
    public void initialize(ValidAge constraintAnnotation) {
        this.minAge = constraintAnnotation.age();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {

        if (s == null) {
            return false;
        }

        try {
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dob = LocalDate.parse(s, formatter);

            int age = Period.between(dob, today).getYears();
            return age >= minAge;

        } catch (Exception ex) {
            return false;
        }
    }

}