/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static persistence.DAO.Dao.getConnection;
import persistence.DAO.interfaces.filmDao;
import persistence.DAO.interfaces.schauspielerfilmDao;
import persistence.entities.Film;
import persistence.entities.Schauspieler;
import persistence.exceptions.CombinationNotFound;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.filmnotfound;

/**
 *
 * @author joker
 */
class schauspielerfilmDaoImpl implements schauspielerfilmDao {

    public ArrayList<Film> findFilmsplayedBySchauspieler(int id) throws filmnotfound {
        String query = ("select * from filme f join schauspieler_to_film x "
                + "on f.filmID = x.f_id "
                + "where x.s_id = '" + id + "'");
        filmDao fd = new filmDaoImpl();
        return fd.getFilms(query);
    }

    public ArrayList<Schauspieler> findSchaupielerWhoPlayedInFilm(int id) throws connectionProblem {
        String query = ("select * from schauspieler f join schauspieler_to_film x on f.id = x.s_id where x.f_id =" + id);
        schauspielerDaoImpl s = new schauspielerDaoImpl();
        return s.getSchauspieler(query);
    }

    public Schauspieler delete(int userid, int filmid) throws filmnotfound, CombinationNotFound, connectionProblem {
        String query = ("delete from usertofilm where f_id=? and s_id=?");
        return updateQuery(query, userid, filmid);
    }

    public Schauspieler insert(int userid, int filmid) throws filmnotfound, CombinationNotFound, connectionProblem {
        String query = "insert into usertofilm values(? , ?)";
        return updateQuery(query, userid, filmid);
    }

    public Schauspieler updateQuery(String query, int f_id, int s_id) throws filmnotfound, connectionProblem, CombinationNotFound {
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(query);
            st.setInt(1, f_id);
            st.setInt(2, s_id);
            st.executeUpdate();
            getConnection().commit();
        } catch (SQLException e) {
            try {
                getConnection().rollback();
                System.out.println("fehler");
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(likefilmDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return findCombination(s_id, f_id);
    }

    public Schauspieler findCombination(int s_id, int f_id) throws CombinationNotFound {
        Schauspieler fi = null;
        schauspielerDaoImpl fd = new schauspielerDaoImpl();
        String query = ("select * from schauspieler_to_film sf join schauspieler f on sf.s_id=f.id where sf.f_id=" + f_id + " and sf.s_id=" + s_id);
        try {
            fi = fd.findByQuery(query);
        } catch (Exception e) {
            throw new CombinationNotFound();
        }
        return fi;
    }
}
