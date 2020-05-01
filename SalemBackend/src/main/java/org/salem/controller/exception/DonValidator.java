package org.salem.controller.exception;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.salem.domain.don.Edon;

public class DonValidator implements ConstraintValidator<DonPreference, String> {

    private Edon eDonFinancial = Edon.DON_FINANCIAL;
    private Edon eDonMaterial = Edon.DON_MATERIAL;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return (value.equals(eDonFinancial.toString()) || value.equals(eDonMaterial.toString()));
    }
}