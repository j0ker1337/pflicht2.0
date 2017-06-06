/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.controlller;

import java.util.ArrayList;
import persistence.controlller.interfaces.Controller;
import persistence.controlller.interfaces.FilmController;
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
class FilmControllerImpl implements FilmController {

    private Controller controller;

    FilmControllerImpl(Controller controller) {
        this.controller = controller;
    }

    @Override
    public FilmDTO findFilmByName(String name) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound, reginotfound {
        return controller.findFilmByName(name);
    }

    @Override
    public FilmDTO findFilmByID(int id) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound, reginotfound {
        return controller.findFilmByID(id);
    }

    @Override
    public ArrayList<FilmDTO> findSubFilm(String x) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound, reginotfound {
        return controller.findSubFilm(x);
    }

    @Override
    public GenreDTO findGenreOfFilm(int id) throws genreNotFound, connectionProblem {
        return controller.findGenreOfFilm(id);
    }

    @Override
    public RegisseurDTO findRegisseurwhoCreatedFilm(int id) throws connectionProblem, reginotfound {
        return controller.findRegisseurwhoCreatedFilm(id);
    }

    @Override
    public ArrayList<FilmDTO> findAllFilm() throws filmnotfound, genreNotFound, connectionProblem, rightsnotfound, reginotfound {
        return controller.findAllFilm();
    }

    @Override
    public GenreDTO findGenreByFilmID(int id) throws genreNotFound, connectionProblem {
        return controller.findGenreByFilmID(id);
    }

    @Override
    public ArrayList<FilmDTO> findFilmsLikedByUser(int id) throws filmnotfound, genreNotFound, connectionProblem, reginotfound {
        return controller.findFilmsLikedByUser(id);

    }

    @Override
    public ArrayList<FilmDTO> findFilmLikedByPerson(String name, String vorname) throws connectionProblem, usernotfound, filmnotfound, genreNotFound, reginotfound {
        return controller.findFilmLikedByPerson(name, vorname);
    }

    @Override
    public ArrayList<SchauspielerDTO> findSchauspielerOfFilm(int id) throws connectionProblem {
        return controller.findSchauspielerOfFilm(id);
    }

    @Override
    public ArrayList<UserDTO> findUsersWhoLikesFilm(int id) throws connectionProblem, usersnotfound, rightsnotfound {
        return controller.findUsersWhoLikesFilm(id);
    }

    @Override
    public ArrayList<UserDTO> findpersonsLikesFilm(String name) throws filmnotfound, connectionProblem, usersnotfound, rightsnotfound {
        return controller.findpersonsLikesFilm(name);
    }

    @Override
    public ArrayList<FilmDTO> getSortedFilmsByLike(int absteigend, int anz) throws filmnotfound, genreNotFound, connectionProblem, absteigendoneminusoneorzero, rightsnotfound, reginotfound {
        return controller.getSortedFilmsByLike(absteigend, anz);
    }

    @Override
    public ArrayList<FilmDTO> getSortedFilmsByLike(int absteigend) throws filmnotfound, genreNotFound, connectionProblem, absteigendoneminusoneorzero, rightsnotfound, reginotfound {
        return controller.getSortedFilmsByLike(absteigend);
    }

    @Override
    public ArrayList<FilmDTO> findAllFilm(boolean active) throws filmnotfound, genreNotFound, connectionProblem, rightsnotfound, reginotfound {
        return controller.findAllFilm(active);
    }

}
