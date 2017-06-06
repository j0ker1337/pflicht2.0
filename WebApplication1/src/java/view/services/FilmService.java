/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.services;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import persistence.controlller.controllerManager;
import persistence.dto.FilmDTO;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.filmnotfound;
import persistence.exceptions.genreNotFound;
import persistence.exceptions.reginotfound;
import persistence.exceptions.rightsnotfound;
import persistence.exceptions.usersnotfound;

/**
 *
 * @author joker
 */
@Named(value = "FILMSE")
@SessionScoped
public class FilmService implements Serializable {

    private controllerManager coManager;
    private FilmDTO current;

    public FilmService() {
        this.coManager = new controllerManager();
    }

    public void edit(int id) {
        try {
            this.current = coManager.getFilmController().findFilmByID(id);
        } catch (filmnotfound ex) {
            Logger.getLogger(FilmService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (genreNotFound ex) {
            Logger.getLogger(FilmService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (connectionProblem ex) {
            Logger.getLogger(FilmService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (usersnotfound ex) {
            Logger.getLogger(FilmService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (rightsnotfound ex) {
            Logger.getLogger(FilmService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (reginotfound ex) {
            Logger.getLogger(FilmService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void redirect(String facesloginxhtml) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().getExternalContext().redirect(
                    facesloginxhtml);
        } catch (IOException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FilmDTO getCurrent() {
        return current;
    }

    public void setCurrent(FilmDTO current) {
        this.current = current;
    }

}
