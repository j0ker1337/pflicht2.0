/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import persistence.DAO.interfaces.genreDao;
import persistence.entities.Genre;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.genreNotFound;

/**
 *
 * @author Nikolay und Don
 */
class genreDaoImpl extends Dao implements genreDao {

    public genreDaoImpl() {
    }

    @Override
    public Genre findById(int id) throws genreNotFound, connectionProblem {
        String query = "select * from genre where genreID='" + id + "'";
        return getGenres(query);
    }

    @Override
    public Genre findByName(String name) throws genreNotFound, connectionProblem {
        String query = "select * from genre where name like '" + name + "'";
        return getGenres(query);
    }

    @Override
    public Genre findGenreByFilmID(int id) throws genreNotFound, connectionProblem {
        String query = "select g.name,g.`genreID` from filme f join genre g on f.genre=g.genreID where f.filmID=" + id;
        return getGenres(query);
    }
    
    @Override
    public ArrayList<Genre> findAllGenre() throws connectionProblem{
        String query = "select * from genre";
        return getGenress(query);
    }

    @Override
    public Genre getGenres(String query) throws genreNotFound, connectionProblem {
        Genre genre = null;
        try {
            genre = new Genre();
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            genre.setId(rs.getInt("genreID"));
            genre.setName(rs.getString("name"));
        } catch (Exception e) {
            System.out.println("fehler");
            e.printStackTrace();
        }
        if (genre == null) {
            throw new genreNotFound();
        }
        return genre;
    }
    
    public ArrayList<Genre> getGenress(String query) throws connectionProblem{
           ArrayList<Genre> al = null;
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            al = new ArrayList<Genre>();
            while (rs.next()) {
                Genre us = new Genre();
                us.setId(rs.getInt("genreID"));
                us.setName(rs.getString("name"));
                al.add(us);
            }
        } catch (SQLException e) {
            System.out.println("fehler");
            throw new connectionProblem();
        }
        return al;
    }
}
