package persistence.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.DAO.interfaces.filmDao;
import persistence.DAO.interfaces.likefilmDao;
import persistence.entities.Film;
import persistence.entities.User;
import persistence.exceptions.CombinationNotFound;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.filmnotfound;
import persistence.exceptions.usernotfound;
import persistence.exceptions.usersnotfound;


 class likefilmDaoImpl extends Dao implements likefilmDao{
    
 
    public likefilmDaoImpl() {
     
    }
    
    public ArrayList<Film> findFilmsLikedByUser(int id) throws filmnotfound {
        String query = ("select * from filme f join usertofilm x "
                + "on f.filmID = x.film "
                + "where x.user = '" + id + "'");
        filmDao fd = new filmDaoImpl();
        return fd.getFilms(query);
    }
    
        public ArrayList<Film> findFilmsLikedByUser(int id,boolean active) throws filmnotfound {
        String query = ("select * from filme f join usertofilm x "
                + "on f.filmID = x.film JOIN person p on x.user=p.UserID"
                + "where p.UserID = '" + id + "' AND p.active="+active);
        filmDao fd = new filmDaoImpl();
        return fd.getFilms(query);
    }
    
    public ArrayList<Film> findFilmsLikedByUser(String name, String vorname) throws connectionProblem, usernotfound, filmnotfound {
        userDaoImpl ud = new userDaoImpl();
        int userID = ud.findUserByName(name, vorname).getUserID();
        return findFilmsLikedByUser(userID);
    }
    
    public ArrayList<User> findUsersWhoLikesFilm(int id) throws connectionProblem, usersnotfound {
        ArrayList<User> al = new ArrayList();
        String query = ("select * from person f join usertofilm x on f.userID = x.user where x.film =" + id);
        userDaoImpl ud = new userDaoImpl();
        return ud.getUsers(query);
    }
    
        public ArrayList<User> findUsersWhoLikesFilm(int id,boolean active) throws connectionProblem, usersnotfound {
        ArrayList<User> al = new ArrayList();
        String query = ("select * from person f join usertofilm x on f.userID = x.user where x.film =" + id+"and x.active="+active);
        userDaoImpl ud = new userDaoImpl();
        return ud.getUsers(query);
    }
    
    public ArrayList<User> findUsersWhoLikesFilm(String name) throws filmnotfound, connectionProblem, usersnotfound {
        filmDao fd = new filmDaoImpl();
        int filmID = fd.findFilmByName(name).getFilmID();
        return findUsersWhoLikesFilm(filmID);
    }
    
        public ArrayList<User> findUsersWhoLikesFilm(String name,boolean active) throws filmnotfound, connectionProblem, usersnotfound {
        filmDao fd = new filmDaoImpl();
        int filmID = fd.findFilmByName(name).getFilmID();
        return findUsersWhoLikesFilm(filmID,active);
    }
    
    public Film findCombination(int userid, int filmid) throws CombinationNotFound {
        Film fi = null;
        filmDao fd = new filmDaoImpl();
        String query = ("select * from usertofilm uf join filme f on uf.film=f.filmID where uf.user=" + userid + " and uf.film=" + filmid);
        try {
            fi = fd.getFilm(query);
        } catch (Exception e) {
            throw new CombinationNotFound();
        }
        return fi;
    }
    
    public Film delete(int userid, int filmid) throws filmnotfound, CombinationNotFound, connectionProblem {
        filmDao fd = new filmDaoImpl();
        String query = ("delete from usertofilm where film=? and user=?");
        return updateQuery(query, userid, filmid);
    }
    
    public Film insert(int userid, int filmid) throws filmnotfound, CombinationNotFound, connectionProblem {
        String query = "insert into usertofilm values(? , ?)";
        return updateQuery(query, userid, filmid);
    }
    
    public Film updateQuery(String query, int userid, int filmid) throws filmnotfound, CombinationNotFound, connectionProblem {
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement st = getConnection().prepareStatement(query);
            st.setInt(1, filmid);
            st.setInt(2, userid);
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
        return findCombination(userid, filmid);
    }
}
