/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.controlller.interfaces;

import java.util.ArrayList;
import persistence.dto.GenreDTO;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.genreNotFound;

/**
 *
 * @author Nikolay und Don
 */
public interface GenreController {

    public GenreDTO findGenreById(int id) throws genreNotFound, connectionProblem;

    public GenreDTO findGenreByName(String name) throws genreNotFound, connectionProblem;
 public ArrayList<GenreDTO> getAllGenre() throws connectionProblem;
}
