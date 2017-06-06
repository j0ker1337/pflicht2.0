/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.controlller;

import java.util.ArrayList;
import persistence.controlller.interfaces.Controller;
import persistence.controlller.interfaces.UserController;
import persistence.dto.RightDTO;
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

/**
 *
 * @author Nikolay und Don
 */
public class UserControllerImpl implements UserController {

    private Controller controller;

    public UserControllerImpl(Controller controller) {
        this.controller = controller;
    }

    @Override
    public UserDTO findUserByName(String name, String vorname) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound, reginotfound {
        return controller.findUserByName(name, vorname);
    }

    @Override
    public UserDTO findUserByID(int id) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound, reginotfound {
        return controller.findUserByID(id);
    }

    @Override
    public UserDTO findUserByUserName(String name) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound, reginotfound {
        return controller.findUserByUserName(name);
    }

    @Override
    public ArrayList<UserDTO> findAllUser() throws connectionProblem, usersnotfound, rightsnotfound, filmnotfound, genreNotFound, reginotfound {
        return controller.findAllUser();
    }

    @Override
    public RightDTO findRightOfUser(int id) throws rightsnotfound {
        return controller.findRightOfUser(id);
    }

    @Override
    public UserDTO update(UserDTO udto) throws UserEmpty, UserIdEmpty, rightsnotfound, RightIdEmpty, UserBNameEmpty, connectionProblem {
        return controller.update(udto);
    }

    @Override
    public UserDTO likes(UserDTO userdto) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound, CombinationNotFound, usersnotfound, reginotfound {
        return controller.likes(userdto);
    }

    @Override
    public UserDTO save(UserDTO udto) throws connectionProblem, rightsnotfound, usernotfound, usernotfound, UserBNameEmpty, UserEmpty, UserFoundException, RightIdEmpty {
        return controller.save(udto);
    }

    public ArrayList<UserDTO> findAllUser(boolean active) throws connectionProblem, usersnotfound, rightsnotfound, filmnotfound, genreNotFound, reginotfound {
        return controller.findAllUser(active);
    }

    public boolean delete(UserDTO userdto) throws connectionProblem, usernotfound {
        return controller.delete(userdto);
    }

}
