
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.controlller.impl.RightControllerImpl;
import persistence.controlller.impl.UserControllerImpl;
import persistence.controlller.interfaces.RightController;
import persistence.controlller.interfaces.UserController;
import persistence.dto.UserDTO;
import persistence.exceptions.RightIdEmpty;
import persistence.exceptions.UserBNameEmpty;
import persistence.exceptions.UserEmpty;
import persistence.exceptions.UserIdEmpty;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.filmnotfound;
import persistence.exceptions.genreNotFound;
import persistence.exceptions.rightsnotfound;
import persistence.exceptions.usernotfound;

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

    public static void main(String[] args) throws rightsnotfound, usernotfound, connectionProblem {
        UserController userController = new UserControllerImpl();
        RightController rightController = new RightControllerImpl();
        UserDTO udto = new UserDTO();
        try {
            udto = userController.findUserById(4);
        } catch (filmnotfound ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (genreNotFound ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        udto.setName("HOST");
        udto.setBname("don1234567");
        try {
            System.err.println(userController.update(udto));
        } catch (UserBNameEmpty ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserEmpty ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RightIdEmpty ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserIdEmpty ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
