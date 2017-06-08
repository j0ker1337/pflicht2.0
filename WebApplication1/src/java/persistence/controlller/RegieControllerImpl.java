/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.controlller;

import java.util.ArrayList;
import persistence.controlller.interfaces.Controller;
import persistence.controlller.interfaces.RegieController;
import persistence.dto.RegisseurDTO;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.reginotfound;

/**
 *
 * @author joker
 */
public class RegieControllerImpl implements RegieController {

    private Controller controller;

    RegieControllerImpl(Controller controller) {
        this.controller = controller;
    }

    @Override
    public ArrayList<RegisseurDTO> getAllRegisseur() throws reginotfound, connectionProblem {
        return controller.getAllRegisseur();
    }

    @Override
    public RegisseurDTO findRegisseurwhoCreatedFilm(int id) throws connectionProblem, reginotfound {
        return controller.findRegisseurwhoCreatedFilm(id);
    }

}
