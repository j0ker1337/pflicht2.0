/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.controlller.interfaces;

import java.util.ArrayList;
import persistence.dto.FilmDTO;
import persistence.dto.GenreDTO;
import persistence.dto.UserDTO;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.filmnotfound;
import persistence.exceptions.genreNotFound;
import persistence.exceptions.rightsnotfound;
import persistence.exceptions.usernotfound;
import persistence.exceptions.usersnotfound;

/**
 *
 * @author Nikolay und Don
 */
public interface FilmController {

    public FilmDTO findById(int id) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound;

    public FilmDTO findFilmByName(String name) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound;

    public ArrayList<FilmDTO> findAllFilm() throws filmnotfound, genreNotFound, connectionProblem;

    public ArrayList<FilmDTO> findSubFilm(String x) throws filmnotfound, genreNotFound, connectionProblem;

    public ArrayList<FilmDTO> findFilmsLikedByUser(int id) throws filmnotfound, genreNotFound, connectionProblem;

    public ArrayList<FilmDTO> findFilmLikedByPerson(String name, String vorname) throws connectionProblem, usernotfound, filmnotfound, genreNotFound;

    public ArrayList<UserDTO> findUsersWhoLikesFilm(int id) throws connectionProblem, usersnotfound, rightsnotfound;

    public ArrayList<UserDTO> findpersonsLikesFilm(String name) throws filmnotfound, connectionProblem, usersnotfound, rightsnotfound;

    public GenreDTO findGenreByFilmID(int id) throws genreNotFound, connectionProblem;
    
    public ArrayList<FilmDTO> getSortedFilmsByLike() throws filmnotfound, genreNotFound, connectionProblem ;
public ArrayList<FilmDTO> getSortedFilmsByLike(int i,int anz) throws filmnotfound, genreNotFound, connectionProblem;
}
