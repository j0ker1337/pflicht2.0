/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.validator.impl;

import javax.faces.validator.FacesValidator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import view.validator.interfaces.StringLenght;

/**
 *
 * @author joker
 */
@FacesValidator("StringLenghtValidator")
public class StringLenghtValidator implements ConstraintValidator<StringLenght, Object> {

    @Override
    public void initialize(StringLenght constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        if (((String) value).length() < 4) {
            context.buildConstraintViolationWithTemplate("Bitte gib mehr als 4 Zeichen ein").addConstraintViolation();
            return false;
        }
        if (((String) value).length() > 100) {
            context.buildConstraintViolationWithTemplate("Deine Eingabe ist zu lang maximal 100").addConstraintViolation();
            return false;
        }
        return true;
    }

}
