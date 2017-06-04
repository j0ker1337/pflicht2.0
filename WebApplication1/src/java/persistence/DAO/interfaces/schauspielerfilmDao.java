/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.DAO.interfaces;

import java.util.ArrayList;
import persistence.entities.Film;
import persistence.entities.Schauspieler;
import persistence.exceptions.CombinationNotFound;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.filmnotfound;

/**
 *
 * @author joker
 */
public interface schauspielerfilmDao {
    
    public ArrayList<Film> findFilmsplayedBySchauspieler(int id) throws filmnotfound;

    public ArrayList<Schauspieler> findSchaupielerWhoPlayedInFilm(int id) throws connectionProblem; 

    public Schauspieler delete(int userid, int filmid) throws filmnotfound, CombinationNotFound, connectionProblem; 

    public Schauspieler insert(int userid, int filmid) throws filmnotfound, CombinationNotFound, connectionProblem; 

    public Schauspieler updateQuery(String query, int f_id, int s_id) throws filmnotfound, connectionProblem, CombinationNotFound;

    public Schauspieler findCombination(int s_id, int f_id) throws CombinationNotFound;

}
