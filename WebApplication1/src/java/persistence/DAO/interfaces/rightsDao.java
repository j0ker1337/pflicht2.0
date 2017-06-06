/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.DAO.interfaces;

import persistence.entities.Rights;
import persistence.exceptions.rightsnotfound;

/**
 *
 * @author joker
 */
public interface rightsDao {

    public Rights findById(int id) throws rightsnotfound;

    public Rights findRightOfUser(int id) throws rightsnotfound;

    public Rights getRights(String query) throws rightsnotfound;

}
