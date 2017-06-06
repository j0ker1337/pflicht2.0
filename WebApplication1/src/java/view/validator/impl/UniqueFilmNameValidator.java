/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.validator.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.validator.FacesValidator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import persistence.controlller.controllerManager;
import persistence.dto.UserDTO;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.filmnotfound;
import persistence.exceptions.genreNotFound;
import persistence.exceptions.reginotfound;
import persistence.exceptions.rightsnotfound;
import persistence.exceptions.usernotfound;
import view.validator.interfaces.UniqueUserName;

/**
 *
 * @author Nikolay und Don
 */
@FacesValidator("UniqueValidator")
public class UniqueFilmNameValidator implements ConstraintValidator<UniqueUserName, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        try {
            controllerManager coManager = new controllerManager();
            UserDTO x = coManager.getUserController().findUserByUserName((String) value);
            if (x != null) {
                context.buildConstraintViolationWithTemplate("User vorhanden").addConstraintViolation();
                return false;
            }
        } catch (connectionProblem ex) {
            context.buildConstraintViolationWithTemplate("Verbindungsprobleme").addConstraintViolation();
            return false;
        } catch (usernotfound ex) {

            return true;

        } catch (rightsnotfound ex) {

        } catch (filmnotfound ex) {

        } catch (genreNotFound ex) {

        } catch (reginotfound ex) {
            Logger.getLogger(UniqueFilmNameValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public void initialize(UniqueUserName constraintAnnotation) {

    }

}
