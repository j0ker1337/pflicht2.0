/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.DAO.interfaces;

import java.util.ArrayList;
import persistence.entities.Schauspieler;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.schauspielernotfound;

/**
 *
 * @author joker
 */
public interface schauspielerDao {

    public Schauspieler findSchauspielerById(int id) throws connectionProblem, schauspielernotfound;

    public Schauspieler delte(int id) throws connectionProblem;

    public Schauspieler insert(Schauspieler schauspieler) throws connectionProblem, schauspielernotfound;

    public Schauspieler findByQuery(String query) throws connectionProblem, schauspielernotfound;

    public ArrayList<Schauspieler> getSchauspieler(String query) throws connectionProblem;
    
    public ArrayList<Schauspieler> findAllSchauspieler() throws connectionProblem, schauspielernotfound;
}
