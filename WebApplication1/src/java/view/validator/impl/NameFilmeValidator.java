/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.validator.impl;

import javax.faces.validator.FacesValidator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import view.validator.interfaces.NameFilme;

/**
 *
 * @author joker
 */
@FacesValidator("NameFilmeValidator")

public class NameFilmeValidator implements ConstraintValidator<NameFilme, Object> {

    @Override
    public void initialize(NameFilme constraintAnnotation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
