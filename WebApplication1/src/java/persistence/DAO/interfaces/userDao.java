/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.DAO.interfaces;

import java.util.ArrayList;
import persistence.entities.User;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.usernotfound;
import persistence.exceptions.usersnotfound;

/**
 *
 * @author joker
 */
public interface userDao {

    public User findUserByName(String name, String vorname) throws connectionProblem, usernotfound;

    public User findUserByID(int id) throws connectionProblem, usernotfound;

    public User findUserByUserName(String name) throws connectionProblem, usernotfound;

    public boolean delete(int id) throws connectionProblem, usernotfound;

    public User insert(User user) throws connectionProblem, usernotfound;

    public User update(User user) throws connectionProblem;

    public User updateWIthOutUserName(User user) throws connectionProblem;

    public ArrayList<User> findAllUser() throws connectionProblem, usersnotfound;

    public ArrayList<User> findAllUser(boolean active) throws connectionProblem, usersnotfound;

    public ArrayList<User> getUsers(String query) throws connectionProblem, usersnotfound;

}
