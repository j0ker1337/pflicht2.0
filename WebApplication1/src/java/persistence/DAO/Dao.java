/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.DAO;

import persistence.connection.DBverbindung;
import persistence.exceptions.connectionProblem;
import java.sql.Connection;

/**
 *
 * @author Nikolay und Don
 */
public class Dao {

    protected static Connection getConnection() throws connectionProblem {
        Connection conn = null;
        try {
            conn = DBverbindung.getConnection();
        } catch (Exception e) {
            throw new connectionProblem();
        }
        if (conn == null) {
            throw new connectionProblem();
        }
        return conn;
    }

}
