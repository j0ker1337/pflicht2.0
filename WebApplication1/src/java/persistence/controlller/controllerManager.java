/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.controlller;

import persistence.controlller.ControllerImpl;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import persistence.controlller.interfaces.Controller;
import persistence.controlller.interfaces.FilmController;
import persistence.controlller.interfaces.GenreController;
import persistence.controlller.interfaces.RightController;
import persistence.controlller.interfaces.UserController;

/**
 *
 * @author joker
 */

@Named(value = "controllerManager")
@Dependent
@ApplicationScoped
public class controllerManager {
        private  FilmController filmController;
        private  UserController userController;
        private  GenreController genreController;
        private  RightController rightController;
        private  Controller controller;
        
        public controllerManager(){
            this.controller = new ControllerImpl();
            this.filmController=new FilmControllerImpl(controller);
            this.rightController = new RightControllerImpl(controller);
            this.userController = new UserControllerImpl(controller);
            this.genreController=new GenreControllerImpl(controller);
            
        }

    public FilmController getFilmController() {
        return filmController;
    }

    public UserController getUserController() {
        return userController;
    }

    public GenreController getGenreController() {
        return genreController;
    }

    public RightController getRightController() {
        return rightController;
    }

    public Controller getController() {
        return controller;
    }
        
        
}
