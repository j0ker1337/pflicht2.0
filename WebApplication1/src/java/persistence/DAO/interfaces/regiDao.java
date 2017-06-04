/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.DAO.interfaces;

import persistence.entities.Regisseur;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.reginotfound;

/**
 *
 * @author joker
 */
public interface regiDao {

    public Regisseur findRegisseurById(int id) throws connectionProblem, reginotfound;

    //"select * from schauspieler_to_film sf join schauspieler f on sf.s_id=f.id where sf.f_id=1 and sf.s_id=" + id;
    public Regisseur findRegisseurwhoCreatedFilm(int id) throws connectionProblem, reginotfound;

    public Regisseur insert(Regisseur regisseur) throws connectionProblem, reginotfound;

    public Regisseur findByQuery(String query) throws connectionProblem, reginotfound;
}
