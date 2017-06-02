/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.validator;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.validator.FacesValidator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import persistence.controlller.impl.UserControllerImpl;
import persistence.dto.UserDTO;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.filmnotfound;
import persistence.exceptions.genreNotFound;
import persistence.exceptions.reginotfound;
import persistence.exceptions.rightsnotfound;
import persistence.exceptions.usernotfound;

/**
 *
 * @author Nikolay und Don
 */
@FacesValidator("myValidator")
public class UniqueValidator implements ConstraintValidator<Unique, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        try {
            UserControllerImpl userControllerImpl = new UserControllerImpl();
            UserDTO x = userControllerImpl.findUserByUserName((String) value);
            if (x != null) {
                context.buildConstraintViolationWithTemplate("User vorhanden").addConstraintViolation();
                return false;
            }
        } catch (connectionProblem ex) {
            context.buildConstraintViolationWithTemplate("Verbindungsprobleme").addConstraintViolation();
            return false;
        } catch (usernotfound ex) {
            context.buildConstraintViolationWithTemplate("Dieser Benutzername ist noch frei").addConstraintViolation();
            return true;

        } catch (rightsnotfound ex) {

        } catch (filmnotfound ex) {

        } catch (genreNotFound ex) {

        } catch (reginotfound ex) {
            Logger.getLogger(UniqueValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public void initialize(Unique constraintAnnotation) {

    }

}
