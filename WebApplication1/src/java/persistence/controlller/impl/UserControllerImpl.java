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
import persistence.dto.UserDTO;
import persistence.exceptions.RightIdEmpty;
import persistence.exceptions.UserBNameEmpty;
import persistence.exceptions.UserEmpty;
import persistence.exceptions.UserFoundException;
import persistence.exceptions.UserIdEmpty;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.filmnotfound;
import persistence.exceptions.genreNotFound;
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
    public ArrayList<UserDTO> findAllUsers() throws connectionProblem, usersnotfound, usersnotfound, rightsnotfound, filmnotfound, genreNotFound {
        return super.findAllUser();
    }

    @Override
    public UserDTO findUserById(int id) throws connectionProblem, rightsnotfound, filmnotfound, usernotfound, genreNotFound {
        return super.findUserByID(id);
    }

    @Override
    public UserDTO findUserByName(String name, String vorname) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound {
        return super.findUserByName(name, vorname);
    }

    /**
     *
     * @param udto
     * @return
     * @throws UserIdEmpty
     * @throws UserBNameEmpty
     * @throws UserFoundException
     * @throws connectionProblem
     * @throws UserEmpty
     * @throws rightsnotfound
     * @throws usernotfound
     * @throws filmnotfound
     * @throws genreNotFound
     * @throws RightIdEmpty
     * @throws persistence.exceptions.CombinationNotFound
     */
    @Override
     public UserDTO update(UserDTO udto) throws UserEmpty, UserIdEmpty, rightsnotfound, RightIdEmpty, UserBNameEmpty, connectionProblem {
        return super.update(udto);
    } 
    
       public UserDTO save(UserDTO udto) throws connectionProblem, rightsnotfound, usernotfound, usernotfound,UserBNameEmpty,UserEmpty,UserFoundException,RightIdEmpty  {
        return super.save(udto);
    }
    

}
