/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.converter;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import persistence.controlller.controllerManager;
import persistence.dto.SchauspielerDTO;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.schauspielernotfound;

/**
 *
 * @author joker
 */
@FacesConverter("FooConverter")
public class FooConverter implements Converter {

    // Init ---------------------------------------------------------------------------------------
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        SchauspielerDTO y = new SchauspielerDTO();
        controllerManager x = FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{controllerManager}", controllerManager.class);
        try {
            y = x.getSchauspielerController().findSchauspielerById(Integer.parseInt(value));
        } catch (connectionProblem ex) {
            Logger.getLogger(FooConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (schauspielernotfound ex) {
            Logger.getLogger(FooConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return y;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf((int) value);
    }

}
