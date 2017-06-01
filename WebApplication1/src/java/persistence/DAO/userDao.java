package persistence.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.entities.User;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.usernotfound;
import persistence.exceptions.usersnotfound;


public class userDao extends Dao {

    public userDao() {
    }

    public User findUserByName(String name, String vorname) throws connectionProblem, usernotfound {
        String query = ("select * from person where name like \'" + name + "\' and vorname like \'" + vorname + "\'");
        return getUser(query);
    }

    public User findUserByID(int id) throws connectionProblem, usernotfound {
        String query = ("select * from person where userID = " + id);
        return getUser(query);
    }

    public User findUserByUserName(String name) throws connectionProblem, usernotfound {
        String query = ("select * from person where benutzerName Like '" + name + "'");
        return getUser(query);
    }

    public User insert(User user) throws connectionProblem, usernotfound {

        String query = ("insert into person (benutzerName ,password,rightsID) values(?,?,?)");
        int id = 0;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement pre = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pre.setString(1, user.getBname());
            pre.setString(2, user.getPass());
            pre.setInt(3, user.getRightsID());
            pre.executeUpdate();
            getConnection().commit();
            ResultSet rs = pre.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException ex) {
            try {
                getConnection().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
            ex.printStackTrace();
            System.out.print("sadasd");
        }
        return findUserByUserName(user.getBname());
    }

    public User update(User user) throws connectionProblem {
        String query = "update person set name=?,vorname=?,geburtsdatum=?,benutzerName=?,password=?,rightsID=? where UserID=?";
        try {
            PreparedStatement pre = getConnection().prepareStatement(query);
            pre.setString(1, user.getName());
            pre.setString(2, user.getVorname());
            pre.setDate(3, user.getGeburt());
            pre.setString(4, user.getBname());
            pre.setString(5, user.getPass());
            pre.setInt(6, user.getRightsID());
            pre.setInt(7, user.getUserID());
            pre.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.print("sadasd");
        }
        return user;
    }
    
        public User updateWIthOutUserName(User user) throws connectionProblem {
        String query = "update person set name=?,vorname=?,geburtsdatum=?,password=?,rightsID=? where UserID=?";
        try {
            PreparedStatement pre = getConnection().prepareStatement(query);
            pre.setString(1, user.getName());
            pre.setString(2, user.getVorname());
            pre.setDate(3, user.getGeburt());
            pre.setString(4, user.getPass());
            pre.setInt(5, user.getRightsID());
            pre.setInt(6, user.getUserID());
            pre.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.print("sadasd");
        }
        return user;
    }

    public ArrayList<User> findAllUser() throws connectionProblem, usersnotfound {
        String query = ("select * from person");
        return getUsers(query);
    }

    private User getUser(String query) throws connectionProblem, usernotfound {
        User us = null;
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            us = new User();
            if (!rs.next()) {
                throw new usernotfound();
            } else {
                us.setUserID(rs.getInt("userID"));
                us.setVorname(rs.getString("vorname"));
                us.setName(rs.getString("name"));
                us.setGeburt(rs.getDate("geburtsdatum"));
                us.setBname(rs.getString("benutzerName"));
                us.setPass(rs.getString("password"));
                us.setRightsID(rs.getInt("rightsID"));
            }
        } catch (SQLException e) {
            System.out.println("fehler");
            e.printStackTrace();
        }
        return us;
    }

    public ArrayList<User> getUsers(String query) throws connectionProblem, usersnotfound {
        ArrayList<User> al = null;
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            al = new ArrayList<User>();
            while (rs.next()) {
                User us = new User();
                us.setUserID(rs.getInt("userID"));
                us.setVorname(rs.getString("vorname"));
                us.setName(rs.getString("name"));
                us.setGeburt(rs.getDate("geburtsdatum"));
                us.setBname(rs.getString("benutzerName"));
                us.setPass(rs.getString("password"));
                us.setRightsID(rs.getInt("rightsID"));
                al.add(us);
            }
        } catch (Exception e) {
            System.out.println("fehler");
            e.printStackTrace();
        }
        return al;
    }


}
