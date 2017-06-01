/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.checker;

import persistence.DAO.DaoManager;
import persistence.entities.User;
import persistence.exceptions.RightIdEmpty;
import persistence.exceptions.UserBNameEmpty;
import persistence.exceptions.UserEmpty;
import persistence.exceptions.UserFoundException;
import persistence.exceptions.UserIdEmpty;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.rightsnotfound;
import persistence.exceptions.usernotfound;

/**
 *
 * @author Nikolay und Don
 */
public class userCheck {

    public static void checkforUpdateUser(User user, DaoManager daoManger) throws UserEmpty, UserIdEmpty, rightsnotfound, RightIdEmpty, UserBNameEmpty, connectionProblem, usernotfound, UserFoundException {
        if (user == null) {
            throw new UserEmpty();
        }
        if (user.getUserID() == 0) {
            throw new UserIdEmpty();
        }
        if(user.getRightsID()==0){
            throw new RightIdEmpty();
        }
             daoManger.getrDao().findById(user.getRightsID());
        if(user.getBname()==null){
            throw new UserBNameEmpty();
        }
        if(daoManger.getUsDao().findUserByUserName(user.getBname())!=null && user.getUserID()!=daoManger.getUsDao().findUserByUserName(user.getBname()).getUserID()){
             throw new UserFoundException();
        }
        else{
            throw new usernotfound();
        }

    }

    public static void checkforSaveUser(User user, DaoManager daoManger) throws UserBNameEmpty, connectionProblem, UserFoundException, UserEmpty, rightsnotfound, usernotfound, RightIdEmpty {
        if (user == null) {
            throw new UserEmpty();
        }
        if (user.getRightsID() == 0) {
            throw new RightIdEmpty();
        }
        daoManger.getrDao().findById(user.getRightsID());
        if (user.getBname() == null) {
            throw new UserBNameEmpty();
        }
        if (daoManger.getUsDao().findUserByUserName(user.getBname()) != null) {
            throw new UserFoundException();
        }

    }
}
