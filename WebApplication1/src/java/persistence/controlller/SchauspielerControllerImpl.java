/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.controlller;

import java.util.ArrayList;
import persistence.controlller.interfaces.Controller;
import persistence.controlller.interfaces.SchauspielerController;
import persistence.dto.SchauspielerDTO;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.schauspielernotfound;

/**
 *
 * @author joker
 */
public class SchauspielerControllerImpl implements SchauspielerController{

    private Controller controller;

    SchauspielerControllerImpl(Controller controller) {
        this.controller = controller;
    }

    public SchauspielerDTO findSchauspielerById(int id) throws connectionProblem, schauspielernotfound {
        return controller.findSchauspielerById(id);
    }

    public SchauspielerDTO delte(int id) throws connectionProblem{
        return controller.delte(id);
    }

    public SchauspielerDTO insert(SchauspielerDTO schauspieler) throws connectionProblem, schauspielernotfound{
        return controller.insert(schauspieler);
    }

    public ArrayList<SchauspielerDTO> findAllSchauspieler() throws connectionProblem, schauspielernotfound{
        return controller.findAllSchauspieler();
    }
}
