/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.controlller.interfaces;

import java.util.ArrayList;
import persistence.dto.RegisseurDTO;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.reginotfound;

/**
 *
 * @author joker
 */
public interface RegieController {
     public ArrayList<RegisseurDTO> getAllRegisseur() throws reginotfound, connectionProblem;
     
         public RegisseurDTO findRegisseurwhoCreatedFilm(int id) throws connectionProblem, reginotfound;
}
