/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.DAO.interfaces;

import java.util.ArrayList;
import persistence.entities.Genre;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.genreNotFound;

/**
 *
 * @author joker
 */
public interface genreDao {

    public Genre findById(int id) throws genreNotFound, connectionProblem;

    public Genre findByName(String name) throws genreNotFound, connectionProblem;

    public Genre findGenreByFilmID(int id) throws genreNotFound, connectionProblem;

    public Genre getGenres(String query) throws genreNotFound, connectionProblem;

    public ArrayList<Genre> findAllGenre() throws connectionProblem;
}
