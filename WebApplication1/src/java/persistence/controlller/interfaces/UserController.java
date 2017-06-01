/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.controlller.interfaces;

import java.util.ArrayList;
import persistence.dto.RightDTO;
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
public interface UserController {

    ArrayList<UserDTO> findAllUsers() throws connectionProblem, usersnotfound, usersnotfound, rightsnotfound, filmnotfound, genreNotFound;

    UserDTO findUserById(int id) throws connectionProblem, rightsnotfound, filmnotfound, usernotfound, genreNotFound;

    UserDTO findUserByUserName(String name) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound;

    RightDTO findRightOfUser(int id) throws rightsnotfound;

    public UserDTO update(UserDTO udto) throws UserEmpty, UserIdEmpty, rightsnotfound, RightIdEmpty, UserBNameEmpty, connectionProblem;

    public UserDTO save(UserDTO udto) throws connectionProblem, rightsnotfound, usernotfound, usernotfound, UserBNameEmpty, UserEmpty, UserFoundException, RightIdEmpty;

}
