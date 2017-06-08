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
import persistence.DAO.interfaces.regiDao;
import persistence.connection.DBverbindung;
import persistence.entities.Regisseur;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.reginotfound;

/**
 *
 * @author joker
 */
class regiDaoImpl implements regiDao {

    @Override
    public Regisseur findRegisseurById(int id) throws connectionProblem, reginotfound {
        String query = "select * from regi where id=" + id;
        return findByQuery(query);
    }

    @Override
    public ArrayList findAllRegisseur() throws connectionProblem, reginotfound {
        String query = "select * from regie";
        return findByQuerys(query);
    }
    @Override
    //"select * from schauspieler_to_film sf join schauspieler f on sf.s_id=f.id where sf.f_id=1 and sf.s_id=" + id;
    @Override
    public Regisseur findRegisseurwhoCreatedFilm(int id) throws connectionProblem, reginotfound {
        String query = "select * from regie r join filme f on f.regie=r.id where f.filmID=" + id;
        System.err.println(query);
        return findByQuery(query);
    }

    @Override
    public Regisseur insert(Regisseur regisseur) throws connectionProblem, reginotfound {
        String query = ("insert into regie (vorname ,nachname) values(?,?)");
        int id = 0;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement pre = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pre.setString(1, regisseur.getVorname());
            pre.setString(2, regisseur.getName());
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
        return findRegisseurById(id);
    }

    @Override
    public Regisseur findByQuery(String query) throws connectionProblem, reginotfound {
        Regisseur r = null;
        try {
            Statement statement = DBverbindung.getConnection().createStatement();
            ResultSet x = statement.executeQuery(query);
            if (x.next()) {
                r = new Regisseur();
                r.setId(x.getInt("id"));
                r.setName(x.getString("nachname"));
                r.setVorname(x.getString("vorname"));
            }

        } catch (SQLException ex) {
            throw new connectionProblem();
        }
        if (r == null) {
            throw new reginotfound();
        }
        return r;
    }
    @Override
    public ArrayList<Regisseur> findByQuerys(String query) throws connectionProblem, reginotfound {
        ArrayList<Regisseur> al = null;
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            al = new ArrayList<Regisseur>();
            while (rs.next()) {
                Regisseur us = new Regisseur();
                us.setId(rs.getInt("id"));
                us.setVorname(rs.getString("vorname"));
                us.setName(rs.getString("nachname"));
                al.add(us);
            }
        } catch (SQLException e) {
            System.out.println("fehler");
            throw new connectionProblem();
        }
        return al;
    }
}
