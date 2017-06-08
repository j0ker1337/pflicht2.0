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
import persistence.dto.RightDTO;
import persistence.dto.SchauspielerDTO;
import persistence.dto.UserDTO;
import persistence.exceptions.CombinationNotFound;
import persistence.exceptions.RightIdEmpty;
import persistence.exceptions.UserBNameEmpty;
import persistence.exceptions.UserEmpty;
import persistence.exceptions.UserFoundException;
import persistence.exceptions.UserIdEmpty;
import persistence.exceptions.absteigendoneminusoneorzero;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.filmnotfound;
import persistence.exceptions.genreNotFound;
import persistence.exceptions.reginotfound;
import persistence.exceptions.rightsnotfound;
import persistence.exceptions.schauspielernotfound;
import persistence.exceptions.usernotfound;
import persistence.exceptions.usersnotfound;

/**
 *
 * @author Nikolay und Don
 */
public interface Controller {

    /**
     *
     * @param name
     * @return
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws connectionProblem
     * @throws usersnotfound
     * @throws rightsnotfound
     * @throws reginotfound
     */
    public FilmDTO findFilmByName(String name) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound, reginotfound;

    /**
     * findet alle activen oder inactiven filme
     *
     * @param name
     * @param active
     * @return
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws connectionProblem
     * @throws usersnotfound
     * @throws rightsnotfound
     * @throws reginotfound
     */
    public FilmDTO findFilmByName(String name, boolean active) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound, reginotfound;

    /**
     *
     * @param id
     * @return
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws connectionProblem
     * @throws usersnotfound
     * @throws rightsnotfound
     * @throws reginotfound
     */
    public FilmDTO findFilmByID(int id) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound, reginotfound;

    /**
     *
     * @param x
     * @return
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws connectionProblem
     * @throws usersnotfound
     * @throws rightsnotfound
     * @throws reginotfound
     */
    public ArrayList<FilmDTO> findSubFilm(String x) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound, reginotfound;

    /**
     * findet alle aktiven oder inaktiven filme mit substring ("from")-> "from
     * dusk till down" , "From ..." usw
     *
     * @param x
     * @param active
     * @return
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws connectionProblem
     * @throws usersnotfound
     * @throws rightsnotfound
     * @throws reginotfound
     */
    public ArrayList<FilmDTO> findSubFilm(String x, boolean active) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound, reginotfound;

    /**
     *
     * @param id
     * @return
     * @throws genreNotFound
     * @throws connectionProblem
     */
    public GenreDTO findGenreOfFilm(int id) throws genreNotFound, connectionProblem;

    /**
     *
     * @param id
     * @return
     * @throws connectionProblem
     * @throws reginotfound
     */
    public RegisseurDTO findRegisseurwhoCreatedFilm(int id) throws connectionProblem, reginotfound;

    /**
     *
     * @return @throws filmnotfound
     * @throws genreNotFound
     * @throws connectionProblem
     * @throws rightsnotfound
     * @throws reginotfound
     */
    public ArrayList<FilmDTO> findAllFilm() throws filmnotfound, genreNotFound, connectionProblem, rightsnotfound, reginotfound;

    /**
     * findet alle aktiven inaktiven filme
     *
     * @param active
     * @return
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws connectionProblem
     * @throws rightsnotfound
     * @throws reginotfound
     */
    public ArrayList<FilmDTO> findAllFilm(boolean active) throws filmnotfound, genreNotFound, connectionProblem, rightsnotfound, reginotfound;

    /**
     *
     * @param id
     * @return
     * @throws genreNotFound
     * @throws connectionProblem
     */
    public GenreDTO findGenreByFilmID(int id) throws genreNotFound, connectionProblem;

    /**
     * findet alle filme die ein user mag
     *
     * @param id
     * @return
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws connectionProblem
     * @throws reginotfound
     */
    public ArrayList<FilmDTO> findFilmsLikedByUser(int id) throws filmnotfound, genreNotFound, connectionProblem, reginotfound;

    /**
     * findet alle inaktiven/aktiven filme eines users
     *
     * @param id
     * @param active
     * @return
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws connectionProblem
     * @throws reginotfound
     */
    public ArrayList<FilmDTO> findFilmsLikedByUser(int id, boolean active) throws filmnotfound, genreNotFound, connectionProblem, reginotfound;

    /**
     * findet alle filme die ein user mag
     *
     * @param name
     * @param vorname
     * @return
     * @throws connectionProblem
     * @throws usernotfound
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws reginotfound
     */
    public ArrayList<FilmDTO> findFilmLikedByPerson(String name, String vorname) throws connectionProblem, usernotfound, filmnotfound, genreNotFound, reginotfound;

    /**
     * findet alle schauspieler eines films
     *
     * @param id
     * @return
     * @throws connectionProblem
     */
    ArrayList<SchauspielerDTO> findSchauspielerOfFilm(int id) throws connectionProblem;

    /**
     * findet alle user die diesen film mögen
     *
     * @param id
     * @return
     * @throws connectionProblem
     * @throws usersnotfound
     * @throws rightsnotfound
     */
    public ArrayList<UserDTO> findUsersWhoLikesFilm(int id) throws connectionProblem, usersnotfound, rightsnotfound;

    /**
     * findet alle aktiven/inaktiven user die diesen film mögen
     *
     * @param id
     * @param active
     * @return
     * @throws connectionProblem
     * @throws usersnotfound
     * @throws rightsnotfound
     */
    public ArrayList<UserDTO> findUsersWhoLikesFilm(int id, boolean active) throws connectionProblem, usersnotfound, rightsnotfound;

    /**
     * findet alle personen die den film mögen
     *
     * @param name
     * @return
     * @throws filmnotfound
     * @throws connectionProblem
     * @throws usersnotfound
     * @throws rightsnotfound
     */
    public ArrayList<UserDTO> findpersonsLikesFilm(String name) throws filmnotfound, connectionProblem, usersnotfound, rightsnotfound;

    /**
     * findet alle aktiven/inaktiven personen die den film mögen
     *
     * @param name
     * @return
     * @throws filmnotfound
     * @throws connectionProblem
     * @throws usersnotfound
     * @throws rightsnotfound
     */
    public ArrayList<UserDTO> findpersonsLikesFilm(String name, boolean active) throws filmnotfound, connectionProblem, usersnotfound, rightsnotfound;

    /**
     * sortierte liste von filmen nach like und anzahl der ergebnisse
     *
     * @param absteigend
     * @param anz
     * @return
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws connectionProblem
     * @throws absteigendoneminusoneorzero
     * @throws rightsnotfound
     * @throws reginotfound
     */
    public ArrayList<FilmDTO> getSortedFilmsByLike(int absteigend, int anz) throws filmnotfound, genreNotFound, connectionProblem, absteigendoneminusoneorzero, rightsnotfound, reginotfound;

    /**
     * sortierte liste von filmen nach like und anzahl der ergebnisse die
     * aktiv/inaktiv sind
     *
     * @param absteigend
     * @param anz
     * @param active
     * @return
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws connectionProblem
     * @throws absteigendoneminusoneorzero
     * @throws rightsnotfound
     * @throws reginotfound
     */
    public ArrayList<FilmDTO> getSortedFilmsByLike(int absteigend, int anz, boolean active) throws filmnotfound, genreNotFound, connectionProblem, absteigendoneminusoneorzero, rightsnotfound, reginotfound;

    /**
     * absteigende/aufsteigende liste von filmen nach likes
     *
     * @param absteigend
     * @return
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws connectionProblem
     * @throws absteigendoneminusoneorzero
     * @throws rightsnotfound
     * @throws reginotfound
     */
    public ArrayList<FilmDTO> getSortedFilmsByLike(int absteigend) throws filmnotfound, genreNotFound, connectionProblem, absteigendoneminusoneorzero, rightsnotfound, reginotfound;

    /**
     * absteigende/aufsteigende liste von aktiven/inaktiven filmen nach likes
     *
     * @param absteigend
     * @param active
     * @return
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws connectionProblem
     * @throws absteigendoneminusoneorzero
     * @throws rightsnotfound
     * @throws reginotfound
     */
    public ArrayList<FilmDTO> getSortedFilmsByLike(int absteigend, boolean active) throws filmnotfound, genreNotFound, connectionProblem, absteigendoneminusoneorzero, rightsnotfound, reginotfound;

    /**
     *
     * @param id
     * @return
     * @throws genreNotFound
     * @throws connectionProblem
     */
    public GenreDTO findGenreById(int id) throws genreNotFound, connectionProblem;

    /**
     *
     * @param name
     * @return
     * @throws genreNotFound
     * @throws connectionProblem
     */
    public GenreDTO findGenreByName(String name) throws genreNotFound, connectionProblem;

    /**
     *
     * @param id
     * @return
     * @throws rightsnotfound
     */
    public RightDTO findRightsById(int id) throws rightsnotfound;

    /**
     *
     * @param name
     * @param vorname
     * @return
     * @throws connectionProblem
     * @throws usernotfound
     * @throws rightsnotfound
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws reginotfound
     */
    public UserDTO findUserByName(String name, String vorname) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound, reginotfound;

    /**
     *
     * @param id
     * @return
     * @throws connectionProblem
     * @throws usernotfound
     * @throws rightsnotfound
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws reginotfound
     */
    public UserDTO findUserByID(int id) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound, reginotfound;

    /**
     *
     * @param name
     * @return
     * @throws connectionProblem
     * @throws usernotfound
     * @throws rightsnotfound
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws reginotfound
     */
    public UserDTO findUserByUserName(String name) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound, reginotfound;

    /**
     * finde alle User
     *
     * @return
     * @throws connectionProblem
     * @throws usersnotfound
     * @throws rightsnotfound
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws reginotfound
     */
    public ArrayList<UserDTO> findAllUser() throws connectionProblem, usersnotfound, rightsnotfound, filmnotfound, genreNotFound, reginotfound;

    /**
     * *
     * findet alle User die aktive/sind
     *
     * @param active
     * @return
     * @throws connectionProblem
     * @throws usersnotfound
     * @throws rightsnotfound
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws reginotfound
     */
    public ArrayList<UserDTO> findAllUser(boolean active) throws connectionProblem, usersnotfound, rightsnotfound, filmnotfound, genreNotFound, reginotfound;

    /**
     *
     * @param id
     * @return
     * @throws rightsnotfound
     */
    public RightDTO findRightOfUser(int id) throws rightsnotfound;

    /**
     *
     * @param udto
     * @return
     * @throws UserEmpty
     * @throws UserIdEmpty
     * @throws rightsnotfound
     * @throws RightIdEmpty
     * @throws UserBNameEmpty
     * @throws connectionProblem
     */
    public UserDTO update(UserDTO udto) throws UserEmpty, UserIdEmpty, rightsnotfound, RightIdEmpty, UserBNameEmpty, connectionProblem;

    /**
     *
     * @param userdto
     * @return
     * @throws connectionProblem
     * @throws usernotfound
     * @throws rightsnotfound
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws CombinationNotFound
     * @throws usersnotfound
     * @throws reginotfound
     */
    public UserDTO likes(UserDTO userdto) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound, CombinationNotFound, usersnotfound, reginotfound;

    /**
     *
     * @param oldl
     * @param newl
     * @param userid
     * @throws filmnotfound
     * @throws connectionProblem
     * @throws CombinationNotFound
     */
    public void checker1(ArrayList<FilmDTO> oldl, ArrayList<FilmDTO> newl, int userid) throws filmnotfound, connectionProblem, CombinationNotFound;

    /**
     *
     * @param udto
     * @return
     * @throws connectionProblem
     * @throws rightsnotfound
     * @throws usernotfound
     * @throws usernotfound
     * @throws UserBNameEmpty
     * @throws UserEmpty
     * @throws UserFoundException
     * @throws RightIdEmpty
     */
    public UserDTO save(UserDTO udto) throws connectionProblem, rightsnotfound, usernotfound, usernotfound, UserBNameEmpty, UserEmpty, UserFoundException, RightIdEmpty;

    /**
     *
     * @param userdto
     * @return
     * @throws connectionProblem
     * @throws usernotfound
     */
    public boolean delete(UserDTO userdto) throws connectionProblem, usernotfound;

    public ArrayList<GenreDTO> getAllGenre() throws connectionProblem;

    public ArrayList<RegisseurDTO> getAllRegisseur() throws reginotfound, connectionProblem;

    public SchauspielerDTO findSchauspielerById(int id) throws connectionProblem, schauspielernotfound;

    public SchauspielerDTO delte(int id) throws connectionProblem;

    public SchauspielerDTO insert(SchauspielerDTO schauspieler) throws connectionProblem, schauspielernotfound;

    public ArrayList<SchauspielerDTO> findAllSchauspieler() throws connectionProblem, schauspielernotfound;

    public FilmDTO insert(FilmDTO film) throws filmnotfound, genreNotFound, connectionProblem;

    public RegisseurDTO findBYId(int id) throws connectionProblem, reginotfound;
}
