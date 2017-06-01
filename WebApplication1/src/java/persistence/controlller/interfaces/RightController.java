/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.controlller.interfaces;

import persistence.dto.RightDTO;
import persistence.exceptions.rightsnotfound;

/**
 *
 * @author Nikolay und Don
 */
public interface RightController {
         public RightDTO findRightsById(int id) throws rightsnotfound;
}
