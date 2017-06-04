package view.validator.impl;

import javax.faces.validator.FacesValidator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import persistence.controlller.controllerManager;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.genreNotFound;
import view.validator.interfaces.IdGenre;


@FacesValidator("IdGenreValidator")
public class IdGenreValidator implements ConstraintValidator<IdGenre, Object> {

    @Override
    public void initialize(IdGenre constraintAnnotation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
             controllerManager controller = new controllerManager();
            if (controller.getGenreController().findGenreById((Integer) value) != null) {

            }
        } catch (genreNotFound ex) {
            context.buildConstraintViolationWithTemplate("die id gibt es nicht").addConstraintViolation();
            return false;
        } catch (connectionProblem ex) {
            context.buildConstraintViolationWithTemplate("connection Probleme (sorry)").addConstraintViolation();
            return false;
        }
        return true;
    }

}
