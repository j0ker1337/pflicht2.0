
import persistence.controlller.impl.FilmControllerImpl;
import persistence.dto.FilmDTO;
import persistence.exceptions.RightIdEmpty;
import persistence.exceptions.UserBNameEmpty;
import persistence.exceptions.UserEmpty;
import persistence.exceptions.UserIdEmpty;
import persistence.exceptions.absteigendoneminusoneorzero;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.filmnotfound;
import persistence.exceptions.genreNotFound;
import persistence.exceptions.reginotfound;
import persistence.exceptions.rightsnotfound;
import persistence.exceptions.usernotfound;
import persistence.exceptions.usersnotfound;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nikolay und Don
 */
public class Main {

    public static void main(String[] args) throws rightsnotfound, usernotfound, connectionProblem, filmnotfound, genreNotFound, reginotfound, usersnotfound, absteigendoneminusoneorzero, UserEmpty, UserIdEmpty, RightIdEmpty, UserBNameEmpty {
         FilmControllerImpl filmControllerImpl = new FilmControllerImpl();
         for(FilmDTO filmDTO : filmControllerImpl.findAllFilm(true)){
             System.err.println(filmDTO);
         }

    }
}
