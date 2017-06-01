/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.controlller.impl;

import java.util.ArrayList;
import javax.enterprise.context.Dependent;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import persistence.controlller.interfaces.FilmController;
import persistence.dto.FilmDTO;
import persistence.dto.GenreDTO;
import persistence.dto.UserDTO;
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
@Named(value = "filmController")
@Dependent
@RequestScoped
public class FilmControllerImpl extends ControllerImpl implements FilmController {

    @Override
    public FilmDTO findById(int id) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound,reginotfound {
        return super.findFilmByID(id);
    }

    @Override
    public FilmDTO findFilmByName(String name) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound,reginotfound {
        return super.findFilmByName(name);
    }

    @Override
    public ArrayList<FilmDTO> findAllFilm() throws filmnotfound, genreNotFound, connectionProblem {
        return super.findAllFilm();
    }

    @Override
    public ArrayList<FilmDTO> findSubFilm(String x) throws filmnotfound, genreNotFound, connectionProblem {
        return super.findSubFilm(x);
    }

    @Override
    public ArrayList<FilmDTO> findFilmsLikedByUser(int id) throws filmnotfound, genreNotFound, connectionProblem {
        return super.findFilmsLikedByUser(id);
    }

    @Override
    public ArrayList<FilmDTO> findFilmLikedByPerson(String name, String vorname) throws connectionProblem, usernotfound, filmnotfound, genreNotFound {
        return super.findFilmLikedByPerson(name, vorname);
    }

    @Override
    public ArrayList<UserDTO> findUsersWhoLikesFilm(int id) throws connectionProblem, usersnotfound, rightsnotfound {
        return super.findUsersWhoLikesFilm(id);
    }

    @Override
    public ArrayList<UserDTO> findpersonsLikesFilm(String name) throws filmnotfound, connectionProblem, usersnotfound, rightsnotfound {
        return super.findpersonsLikesFilm(name);
    }

    @Override
    public GenreDTO findGenreByFilmID(int id) throws genreNotFound, connectionProblem {
        return super.findGenreByFilmID(id);
    }

    @Override
    public ArrayList<FilmDTO> getSortedFilmsByLike(int i,int anz) throws filmnotfound, genreNotFound, connectionProblem {
        return super.getSortedFilmsByLike(i,anz);
    }

    @Override
    public ArrayList<FilmDTO> getSortedFilmsByLike() throws filmnotfound, genreNotFound, connectionProblem {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
