/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static persistence.DAO.Dao.getConnection;
import persistence.DAO.interfaces.schauspielerDao;
import persistence.connection.DBverbindung;
import persistence.entities.Schauspieler;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.schauspielernotfound;

/**
 *
 * @author joker
 */
 class schauspielerDaoImpl implements schauspielerDao{

    public Schauspieler findSchauspielerById(int id) throws connectionProblem, schauspielernotfound {
        String query = "select * from schauspieler where id=" + id;
        return findByQuery(query);
    }
    
    public Schauspieler delte(int id) throws connectionProblem{
        String query = "delete from schauspieler where id="+id;
         try {
            getConnection().setAutoCommit(false);
            PreparedStatement pre = getConnection().prepareStatement(query);
            pre.executeUpdate();
        } catch (SQLException ex) {
            try {
                getConnection().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(schauspielerDaoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
         return null;
    }

    public Schauspieler insert(Schauspieler schauspieler) throws connectionProblem, schauspielernotfound {
        String query = ("insert into schauspieler (vorname ,nachname) values(?,?)");
        int id = 0;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement pre = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pre.setString(1, schauspieler.getVorname());
            pre.setString(2, schauspieler.getName());
            pre.executeUpdate();
            getConnection().commit();
            ResultSet rs = pre.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException ex) {
            try {
                getConnection().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(userDaoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            ex.printStackTrace();
            System.out.print("sadasd");
        }
        return findSchauspielerById(id);
    }

    public Schauspieler findByQuery(String query) throws connectionProblem, schauspielernotfound {
        Schauspieler r = null;
        try {
            Statement statement = DBverbindung.getConnection().createStatement();
            ResultSet x = statement.executeQuery(query);
            if (x.next()) {
                r = new Schauspieler();
                r.setId(x.getInt("id"));
                r.setName(x.getString("nachname"));
                r.setVorname(x.getString("vorname"));
            }

        } catch (SQLException ex) {
            throw new connectionProblem();
        }
        if (r == null) {
            throw new schauspielernotfound();
        }
        return r;
    }

    public ArrayList<Schauspieler> getSchauspieler(String query) throws connectionProblem {
        ArrayList<Schauspieler> al = null;
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            al = new ArrayList<Schauspieler>();
            while (rs.next()) {
                Schauspieler us = new Schauspieler();
                us.setId(rs.getInt("id"));
                us.setVorname(rs.getString("vorname"));
                us.setName(rs.getString("nachname"));
                al.add(us);
            }
        } catch (Exception e) {
            System.out.println("fehler");
            e.printStackTrace();
            throw new connectionProblem();
        }
        return al;
    }

}
