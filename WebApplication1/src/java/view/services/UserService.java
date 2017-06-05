/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.services;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import persistence.controlller.controllerManager;
import persistence.dto.FilmDTO;
import persistence.dto.UserDTO;
import persistence.exceptions.RightIdEmpty;
import persistence.exceptions.UserBNameEmpty;
import persistence.exceptions.UserEmpty;
import persistence.exceptions.UserIdEmpty;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.filmnotfound;
import persistence.exceptions.genreNotFound;
import persistence.exceptions.reginotfound;
import persistence.exceptions.rightsnotfound;
import persistence.exceptions.usernotfound;

/**
 *
 * @author Nikolay und Don
 */
@Named(value = "userService")
@Dependent
@SessionScoped
public class UserService {

    private UserDTO currentUser;
    private controllerManager coManager;

    public UserDTO getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserDTO currentUser) {
        this.currentUser = currentUser;
    }

    public UserService() {
        this.coManager = new controllerManager();
        try {
            this.currentUser=coManager.getUserController().findUserByID(2);
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
        }
    }
    
    
    public void add(FilmDTO dto){
        System.err.println("\n"+currentUser.getLikes());
        currentUser.getLikes().add(dto);
        System.err.println("\n"+currentUser.getLikes());
        
    }
    
    public void update(){
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
    /*
    public void register(RegisterDTO reg) throws rightsnotfound {
        System.err.println(reg);
        UserDTO dto = new UserDTO();
        currentUser.setPass(reg.getPassword());
        currentUser.setBname(reg.getBenutzername());
        currentUser.setRight(userController.findRightOfUser(1));
        try {
            this.currentUser = userController.save(dto);
        } catch (connectionProblem ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            redirect("/faces/login.xhtml");
        } catch (usernotfound ex) {
            redirect("/faces/login.xhtml");
        }
        redirect("/faces/xxx.xhtml");
    }

    public void login(LoginDTO log) throws rightsnotfound {
        UserDTO dto = new UserDTO();
        try {
            dto = userController.findUserByUserName(log.getUsername());
            if (!(dto.getPass().equals(log.getPassword()))) {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Incorrect Username and Password",
                                "Please enter correct username or Password"));

                redirect("login.xhtml");

            } else {
                this.currentUser = dto;
            }

        } catch (connectionProblem ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (usernotfound ex) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Incorrect Username and Password",
                            "Please enter correct username or Password"));

            redirect("login.xhtml");

        } catch (filmnotfound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (genreNotFound ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        redirect("xxx.xhtml");
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    public void check() throws IOException {
        if (this.currentUser == null) {
            FacesContext.getCurrentInstance().addMessage(
                    "bla",
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Bitte log dich ein",
                            "Please enter correct username or Password"));

            redirect("faces/login.xhtml");
        }
        redirect("faces/login.xhtml");
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

    private void visit(String name) {
        try {
            this.userController.findUserByUserName(name);
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
        }
    }
     */
}
