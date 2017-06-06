/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.controlller;

import persistence.controlller.interfaces.Controller;
import persistence.controlller.interfaces.RightController;
import persistence.dto.RightDTO;
import persistence.exceptions.rightsnotfound;

/**
 *
 * @author Nikolay und Don
 */
class RightControllerImpl implements RightController {

    private Controller controller;

    public RightControllerImpl(Controller controller) {
        this.controller = controller;
    }

    @Override
    public RightDTO findRightsById(int id) throws rightsnotfound {
        return controller.findRightsById(id);
    }
}
