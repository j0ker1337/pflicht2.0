/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.controlller.interfaces;

import java.util.ArrayList;
import persistence.dto.FilmDTO;
import persistence.dto.GenreDTO;
import persistence.dto.RegisseurDTO;
import persistence.dto.SchauspielerDTO;
import persistence.dto.UserDTO;
import persistence.exceptions.absteigendoneminusoneorzero;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.filmnotfound;
import persistence.exceptions.genreNotFound;
import persistence.exceptions.reginotfound;
import persistence.exceptions.rightsnotfound;
import persistence.exceptions.usernotfound;
import persistence.exceptions.usersnotfound;

/**
 *
 * @author Nikolay und Don
 */
public interface FilmController {



    public FilmDTO findFilmByName(String name) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound, reginotfound;

    public FilmDTO findFilmByID(int id) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound, reginotfound;

    public ArrayList<FilmDTO> findSubFilm(String x) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound, reginotfound;

    public GenreDTO findGenreOfFilm(int id) throws genreNotFound, connectionProblem;

    public RegisseurDTO findRegisseurwhoCreatedFilm(int id) throws connectionProblem, reginotfound;

    public ArrayList<FilmDTO> findAllFilm() throws filmnotfound, genreNotFound, connectionProblem, rightsnotfound, reginotfound;

    public GenreDTO findGenreByFilmID(int id) throws genreNotFound, connectionProblem;

    public ArrayList<FilmDTO> findFilmsLikedByUser(int id) throws filmnotfound, genreNotFound, connectionProblem, reginotfound;

    public ArrayList<FilmDTO> findFilmLikedByPerson(String name, String vorname) throws connectionProblem, usernotfound, filmnotfound, genreNotFound, reginotfound;

    ArrayList<SchauspielerDTO> findSchauspielerOfFilm(int id) throws connectionProblem;

    public ArrayList<UserDTO> findUsersWhoLikesFilm(int id) throws connectionProblem, usersnotfound, rightsnotfound;

    public ArrayList<UserDTO> findpersonsLikesFilm(String name) throws filmnotfound, connectionProblem, usersnotfound, rightsnotfound;

    public ArrayList<FilmDTO> getSortedFilmsByLike(int absteigend, int anz) throws filmnotfound, genreNotFound, connectionProblem, absteigendoneminusoneorzero, rightsnotfound, reginotfound;

    public ArrayList<FilmDTO> getSortedFilmsByLike(int absteigend) throws filmnotfound, genreNotFound, connectionProblem, absteigendoneminusoneorzero, rightsnotfound, reginotfound;

    public ArrayList<FilmDTO> findAllFilm(boolean active) throws filmnotfound, genreNotFound, connectionProblem, rightsnotfound, reginotfound;
}
