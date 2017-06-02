/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.controlller.impl;

import java.util.ArrayList;
import javax.enterprise.context.Dependent;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
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
@Named(value = "userController")
@Dependent
@RequestScoped
public class UserControllerImpl extends ControllerImpl implements UserController {

    @Override
    public UserDTO findUserByName(String name, String vorname) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound, reginotfound {
        return super.findUserByName(name, vorname);
    }

    @Override
    public UserDTO findUserByID(int id) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound, reginotfound {
        return super.findUserByID(id);
    }

    @Override
    public UserDTO findUserByUserName(String name) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound, reginotfound {
        return super.findUserByUserName(name);
    }

    @Override
    public ArrayList<UserDTO> findAllUser() throws connectionProblem, usersnotfound, rightsnotfound, filmnotfound, genreNotFound, reginotfound {
        return super.findAllUser();
    }

    @Override
    public RightDTO findRightOfUser(int id) throws rightsnotfound {
        return super.findRightOfUser(id);
    }

    @Override
    public UserDTO update(UserDTO udto) throws UserEmpty, UserIdEmpty, rightsnotfound, RightIdEmpty, UserBNameEmpty, connectionProblem {
        return super.update(udto);
    }

    @Override
    public UserDTO likes(UserDTO userdto) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound, CombinationNotFound, usersnotfound, reginotfound {
        return super.likes(userdto);
    }

    @Override
    public UserDTO save(UserDTO udto) throws connectionProblem, rightsnotfound, usernotfound, usernotfound, UserBNameEmpty, UserEmpty, UserFoundException, RightIdEmpty {
        return super.save(udto);
    }

}
