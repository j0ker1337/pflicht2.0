
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.controlller.controllerManager;
import persistence.dto.UserDTO;
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
            UserDTO j = new UserDTO();
            j.setRight(x.getRightController().findRightsById(1));
            j.setBname("asdasdffgdfgd5234534534dasd");
            j.setPass("asasdasdasdasdasd");
            x.getUserController().save(j);
        } catch (UserFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
