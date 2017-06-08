/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.controlller.interfaces;

import java.util.ArrayList;
import persistence.dto.SchauspielerDTO;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.schauspielernotfound;

/**
 *
 * @author joker
 */
public interface SchauspielerController {

    public SchauspielerDTO findSchauspielerById(int id) throws connectionProblem, schauspielernotfound;

    public SchauspielerDTO delte(int id) throws connectionProblem;

    public SchauspielerDTO insert(SchauspielerDTO schauspieler) throws connectionProblem, schauspielernotfound;

    public ArrayList<SchauspielerDTO> findAllSchauspieler() throws connectionProblem, schauspielernotfound;
}
