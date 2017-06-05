package persistence.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.DAO.interfaces.userDao;
import persistence.entities.User;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.usernotfound;
import persistence.exceptions.usersnotfound;

 class userDaoImpl extends Dao  implements userDao   {

    public userDaoImpl() {
    }

    @Override
    public User findUserByName(String name, String vorname) throws connectionProblem, usernotfound {
        String query = ("select * from person where name like \'" + name + "\' and vorname like \'" + vorname + "\'");
        return getUser(query);
    }

    @Override
    public User findUserByID(int id) throws connectionProblem, usernotfound {
        String query = ("select * from person where userID = " + id);
        return getUser(query);
    }

    @Override
    public User findUserByUserName(String name) throws connectionProblem, usernotfound {
        String query = ("select * from person where benutzerName Like '" + name + "'");
        return getUser(query);
    }

    @Override
    public boolean delete(int id) throws connectionProblem, usernotfound {
        String query = ("update person set active=" + false + " where UserID=" + id);
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement pre = getConnection().prepareStatement(query);
            pre.executeUpdate();
            getConnection().commit();
        } catch (SQLException ex) {
            try {
                getConnection().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(userDaoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return true;
    }

    @Override
    public User insert(User user) throws connectionProblem, usernotfound {
        String query = ("insert into person (benutzerName ,password,rightsID,vorname,name) values(?,?,?,?,?)");
        int id = 0;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement pre = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pre.setString(1, user.getBname());
            pre.setString(2, user.getPass());
            pre.setInt(3, user.getRightsID());
            pre.setString(4, user.getVorname());
            pre.setString(5, user.getName());
            pre.executeUpdate();
            getConnection().commit();
            ResultSet rs = pre.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException ex) {
            try {
                System.err.println("ROLLBACK!");
                getConnection().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(userDaoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            ex.printStackTrace();
            System.out.print("sadasd");
        }
        return findUserByUserName(user.getBname());
    }

    @Override
    public User update(User user) throws connectionProblem {
        String query = "update person set name=?,vorname=?,geburtsdatum=?,benutzerName=?,password=?,rightsID=?,active=? where UserID=?";
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement pre = getConnection().prepareStatement(query);
            pre.setString(1, user.getName());
            pre.setString(2, user.getVorname());
            pre.setDate(3, user.getGeburt());
            pre.setString(4, user.getBname());
            pre.setString(5, user.getPass());
            pre.setInt(6, user.getRightsID());
            pre.setBoolean(7, user.isActive());
            pre.setInt(8, user.getUserID());
            System.err.println(pre);
            pre.executeUpdate();
            getConnection().commit();
        } catch (SQLException ex) {
            try {
                getConnection().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(userDaoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            System.out.print("sadasd");
        }
        return user;
    }

    @Override
    public User updateWIthOutUserName(User user) throws connectionProblem {
        String query = "update person set name=?,vorname=?,geburtsdatum=?,password=?,rightsID=?,active=? where UserID=?";
        try {
            PreparedStatement pre = getConnection().prepareStatement(query);
            pre.setString(1, user.getName());
            pre.setString(2, user.getVorname());
            pre.setDate(3, user.getGeburt());
            pre.setString(4, user.getPass());
            pre.setInt(5, user.getRightsID());
                        pre.setBoolean(6, user.isActive());
            pre.setInt(7, user.getUserID());

            pre.executeUpdate();

        } catch (SQLException ex) {
            System.out.print("sadasd");
        }
        return user;
    }

    @Override
    public ArrayList<User> findAllUser() throws connectionProblem, usersnotfound {
        String query = ("select * from person");
        return getUsers(query);
    }

    @Override
    public ArrayList<User> findAllUser(boolean active) throws connectionProblem, usersnotfound {
        String query = ("select * from person where active=" + active);
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
                us.setActive(rs.getBoolean("active"));
                us.setActive(true);
            }
        } catch (SQLException e) {
            System.out.println("fehler");
        }
        return us;
    }
    @Override
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
                us.setActive(rs.getBoolean("active"));
                al.add(us);
            }
        } catch (SQLException e) {
            System.out.println("fehler");
        }
        return al;
    }

}
