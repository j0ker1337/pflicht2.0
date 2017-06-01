/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.controlller.interfaces;

import java.util.ArrayList;
import persistence.dto.FilmDTO;
import persistence.dto.GenreDTO;
import persistence.dto.RightDTO;
import persistence.dto.UserDTO;
import persistence.exceptions.RightIdEmpty;
import persistence.exceptions.UserBNameEmpty;
import persistence.exceptions.UserEmpty;
import persistence.exceptions.UserFoundException;
import persistence.exceptions.UserIdEmpty;
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
public interface Controller {

    public FilmDTO findFilmByName(String name) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound;

    public FilmDTO findFilmByID(int id) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound;

    public ArrayList<FilmDTO> findAllFilm() throws filmnotfound, genreNotFound, connectionProblem;

    public GenreDTO findGenreByFilmID(int id) throws genreNotFound, connectionProblem;

    public ArrayList<FilmDTO> findSubFilm(String x) throws filmnotfound, genreNotFound, connectionProblem;

    public GenreDTO findGenreById(int id) throws genreNotFound, connectionProblem;

    public GenreDTO findGenreByName(String name) throws genreNotFound, connectionProblem;

    public ArrayList<FilmDTO> findFilmsLikedByUser(int id) throws filmnotfound, genreNotFound, connectionProblem;

    public ArrayList<FilmDTO> findFilmLikedByPerson(String name, String vorname) throws connectionProblem, usernotfound, filmnotfound, genreNotFound;

    public ArrayList<UserDTO> findUsersWhoLikesFilm(int id) throws connectionProblem, usersnotfound, rightsnotfound;

    public ArrayList<UserDTO> findpersonsLikesFilm(String name) throws filmnotfound, connectionProblem, usersnotfound, rightsnotfound;

    public RightDTO findRightsById(int id) throws rightsnotfound;

    public UserDTO findUserByName(String name, String vorname) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound;

    public UserDTO findUserByID(int id) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound;

    public UserDTO findUserByUserName(String name) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound;

    public ArrayList<UserDTO> findAllUser() throws connectionProblem, usersnotfound, rightsnotfound, filmnotfound, genreNotFound;

    public RightDTO findRightOfUser(int id) throws rightsnotfound;

    public UserDTO update(UserDTO udto) throws UserEmpty, UserIdEmpty, rightsnotfound, RightIdEmpty, UserBNameEmpty, connectionProblem;

    public ArrayList<FilmDTO> getSortedFilmsByLike(int absteigend) throws filmnotfound, genreNotFound, connectionProblem;

    public ArrayList<FilmDTO> getSortedFilmsByLike(int i, int anz) throws filmnotfound, genreNotFound, connectionProblem;

    public UserDTO save(UserDTO udto) throws connectionProblem, rightsnotfound, usernotfound, usernotfound, UserBNameEmpty, UserEmpty, UserFoundException, RightIdEmpty;

}
