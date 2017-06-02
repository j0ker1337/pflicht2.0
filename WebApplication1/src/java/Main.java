
import persistence.controlller.impl.FilmControllerImpl;
import persistence.controlller.interfaces.FilmController;
import persistence.dto.FilmDTO;
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

    public static void main(String[] args) throws rightsnotfound, usernotfound, connectionProblem, filmnotfound, genreNotFound, reginotfound, usersnotfound, absteigendoneminusoneorzero {
       FilmController filmController = new FilmControllerImpl();
        System.err.println(filmController.findFilmsLikedByUser(2));
        System.err.println("\n"+filmController.findRegisseurwhoCreatedFilm(1));
            System.err.println("\n"+filmController.findSchauspielerOfFilm(1));
             System.err.println("\n"+filmController.findSubFilm("From"));
             for(FilmDTO x :filmController.getSortedFilmsByLike(1, 3) )
             System.err.println("\n"+x);
    }   
}
