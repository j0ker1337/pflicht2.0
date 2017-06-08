/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.services;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import persistence.controlller.controllerManager;
import persistence.dto.FilmDTO;
import persistence.dto.UserDTO;
import persistence.exceptions.CombinationNotFound;
import persistence.exceptions.RightIdEmpty;
import persistence.exceptions.UserBNameEmpty;
import persistence.exceptions.UserEmpty;
import persistence.exceptions.UserFoundException;
import persistence.exceptions.UserIdEmpty;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.filmnotfound;
import persistence.exceptions.genreNotFound;
import persistence.exceptions.reginotfound;
import persistence.exceptions.rightsnotfound;
import persistence.exceptions.usernotfound;
import persistence.exceptions.usersnotfound;
import view.POJO.LoginPOJO;
import view.POJO.RegisterPOJO;

/**
 *
 * @author Nikolay und Don
 */
@Named(value = "USERSE")
@SessionScoped
public class UserService implements Serializable {

    private UserDTO currentUser;
    private controllerManager coManager;
    private Date date;
    private ArrayList<FilmDTO> films;

    public ArrayList<FilmDTO> getFilms() {
        return films;
    }

    public void setFilms(ArrayList<FilmDTO> films) {
        this.films = films;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserDTO getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserDTO currentUser) {
        this.currentUser = currentUser;
    }

    public UserService()  {
        this.coManager = FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{controllerManager}", controllerManager.class);
        date = new Date(System.currentTimeMillis());
        currentUser = new UserDTO();
        try {
            this.films=coManager.getFilmController().findAllFilm();      //filmliste schon beim konstruktor setzen. Nils
            /*try {
            this.currentUser = coManager.getUserController().findUserByID(1);
            } catch (connectionProblem ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (usernotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (rightsnotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (filmnotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (genreNotFound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (reginotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        } catch (genreNotFound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (connectionProblem ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (rightsnotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (reginotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (filmnotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update() {
        try {
            coManager.getUserController().update(currentUser);
        } catch (UserEmpty ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserIdEmpty ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (rightsnotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RightIdEmpty ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserBNameEmpty ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (connectionProblem ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void register(RegisterPOJO reg) throws rightsnotfound, connectionProblem, usernotfound, UserBNameEmpty, UserEmpty, UserFoundException, RightIdEmpty {
        System.err.println(reg);
        currentUser.setPass(reg.getPassword());
        currentUser.setBname(reg.getBenutzername());
        currentUser.setName(reg.getNachname());
        currentUser.setVorname(reg.getVorname());
        currentUser.setRight(coManager.getRightController().findRightsById(1));
        this.currentUser = coManager.getUserController().save(currentUser);
    }

    public void login(LoginPOJO log) throws rightsnotfound {
        UserDTO dto = new UserDTO();
        try {
            dto = coManager.getUserController().findUserByUserName(log.getUsername());
            if (!(dto.getPass().equals(log.getPassword()))) {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Incorrect Username or Password",
                                "Please enter correct username or Password"));
            } else {
                this.currentUser = dto;
                redirect("Hauptseite.xhtml");
                return;
            }

        } catch (connectionProblem ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (usernotfound ex) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Incorrect Username or Password",
                            "Please enter correct username or Password"));
            redirect("error.xhtml");
            return;
        } catch (filmnotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (genreNotFound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (reginotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        redirect("error.xhtml");
        return;
    }

    public void check() throws IOException {
        if (this.currentUser == null) {
            FacesContext.getCurrentInstance().addMessage(
                    "bla",
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Bitte log dich ein",
                            "Please enter correct username or Password"));

        }

    }

    private void redirect(String url) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().getExternalContext().redirect(
                    url);
        } catch (IOException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();
    }

    private void visit(String name) {
        try {
            this.coManager.getUserController().findUserByUserName(name);
        } catch (connectionProblem ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (usernotfound ex) {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.FACES_MESSAGES,
                            "User nicht gefunden"));

            redirect("login");
        } catch (rightsnotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (filmnotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (genreNotFound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (reginotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<FilmDTO> findAllFilms() {
        ArrayList<FilmDTO> x = new ArrayList<FilmDTO>();
        try {
            x = coManager.getFilmController().findAllFilm();
            for (FilmDTO y : x) {
                if (currentUser.getLikes().contains(y)) {
                    y.setIhave(true);
                } else {
                    y.setIhave(false);
                }
            }
            films = x;
            for (FilmDTO y : films) {
                System.err.println(y);
            }

        } catch (filmnotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (genreNotFound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (connectionProblem ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (rightsnotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (reginotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }


    public void add(FilmDTO dTO) throws connectionProblem, filmnotfound, genreNotFound {
        currentUser.getLikes().add(dTO);
        try {
            coManager.getUserController().likes(currentUser);
        } catch (usernotfound ex1) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex1);
        } catch (rightsnotfound ex1) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex1);
        } catch (CombinationNotFound ex1) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex1);
        } catch (usersnotfound ex1) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex1);
        } catch (reginotfound ex1) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }

    public void delete(FilmDTO dTO) throws usersnotfound, reginotfound {
        currentUser.getLikes().remove(dTO);
        try {
            coManager.getUserController().likes(currentUser);
            currentUser = coManager.getUserController().findUserByID(currentUser.getId());
        } catch (connectionProblem ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (usernotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (rightsnotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (filmnotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (genreNotFound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CombinationNotFound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
