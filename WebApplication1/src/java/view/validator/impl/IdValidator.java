/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.validator.impl;

import javax.faces.validator.FacesValidator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import view.validator.interfaces.Id;

/**
 *
 * @author joker
 */
@FacesValidator("IdValidator")
public class IdValidator implements ConstraintValidator<Id, Object>{

    @Override
    public void initialize(Id constraintAnnotation) {
        
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if((Integer)value<=0){
              context.buildConstraintViolationWithTemplate("die id ist ungültig").addConstraintViolation();
             return false;
        }
        return true;
    }
    
}