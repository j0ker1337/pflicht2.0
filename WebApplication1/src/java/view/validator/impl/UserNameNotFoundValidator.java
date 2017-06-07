/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.validator.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import persistence.controlller.controllerManager;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.filmnotfound;
import persistence.exceptions.genreNotFound;
import persistence.exceptions.reginotfound;
import persistence.exceptions.rightsnotfound;
import persistence.exceptions.usernotfound;
import view.validator.interfaces.UserNameNotFound;

/**
 *
 * @author joker
 */
@FacesValidator("UserNameNotFoundValidator")
public class UserNameNotFoundValidator implements ConstraintValidator<UserNameNotFound, Object> {

    @Override
    public void initialize(UserNameNotFound constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        context.buildConstraintViolationWithTemplate("").addConstraintViolation();
        context.disableDefaultConstraintViolation();
        controllerManager x = FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{controllerManager}", controllerManager.class);
        try {
            x.getUserController().findUserByUserName((String) value);
        } catch (connectionProblem ex) {
            Logger.getLogger(UserNameNotFoundValidator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (usernotfound ex) {
            StringBuffer buf = new StringBuffer( "Username oder Passwort leider falsch" );
             context.buildConstraintViolationWithTemplate(buf.toString()).addConstraintViolation();
            return false;
        } catch (rightsnotfound ex) {
            Logger.getLogger(UserNameNotFoundValidator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (filmnotfound ex) {
            Logger.getLogger(UserNameNotFoundValidator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (genreNotFound ex) {
            Logger.getLogger(UserNameNotFoundValidator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (reginotfound ex) {
            Logger.getLogger(UserNameNotFoundValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
