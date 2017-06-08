
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.controlller.controllerManager;
import persistence.dto.FilmDTO;
import persistence.dto.SchauspielerDTO;
import persistence.dto.UserDTO;
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
import persistence.exceptions.schauspielernotfound;
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
        try {
            controllerManager x = new controllerManager();
            FilmDTO film = new FilmDTO();
            film.setActive(true);
            film.setJahr(1990);
            film.setName("sadasdasdasdas");
            film.setRegisseurDTO(x.getRegieController().findRegisseurwhoCreatedFilm(1));
            ArrayList<SchauspielerDTO> sch=new ArrayList<SchauspielerDTO>();
            sch.add(x.getSchauspielerController().findSchauspielerById(1));
            sch.add(x.getSchauspielerController().findSchauspielerById(2));
            film.setSchauspieler(sch);
            ArrayList<UserDTO> users = new ArrayList<UserDTO>();
            users.add(x.getUserController().findUserByID(1));
            users.add(x.getUserController().findUserByID(2));
            film.setUsers(users);
            film.setGenre(x.getGenreController().findGenreById(1));
            x.getFilmController().insert(film);
        } catch (schauspielernotfound ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
}
