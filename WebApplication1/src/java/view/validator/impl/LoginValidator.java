/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.validator.impl;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Nikolay und Don
 */
@FacesValidator("NameFilmeValidator")
public class LoginValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        UIInput input1 = (UIInput) component.getAttributes().get("login_password");
        UIInput input2 = (UIInput) component.getAttributes().get("login_user");

        Object value1 = input1.getSubmittedValue();
        Object value2 = input2.getSubmittedValue();

        return;
        // ...
    }

}
