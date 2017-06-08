package persistence.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.DAO.interfaces.filmDao;
import persistence.entities.Film;
import persistence.exceptions.filmnotfound;

class filmDaoImpl extends Dao implements filmDao {

    public filmDaoImpl() {
    }

    public Film findFilmByName(String name) throws filmnotfound {
        String query = ("select * from filme where name like \'" + name + "\'");
        return getFilm(query);
    }

    public Film findFilmByName(String name, boolean active) throws filmnotfound {
        String query = ("select * from filme where name like \'" + name + "\' and active=" + active);
        return getFilm(query);
    }

    public Film findFilmByID(int id) throws filmnotfound {
        String query = ("select * from filme where filmID = " + id);
        return getFilm(query);
    }

    public ArrayList<Film> findAllFilm() throws filmnotfound {
        String query = ("select * from filme");
        return getFilms(query);
    }

    public ArrayList<Film> findAllFilm(boolean active) throws filmnotfound {
        String query = ("select * from filme where active=" + active);
        return getFilms(query);
    }

    public ArrayList<Film> findSubFilm(String x) throws filmnotfound {
        String query = ("select * from filme where name like \'" + x + "%\'");
        return getFilms(query);
    }

    public ArrayList<Film> findSubFilm(String x, boolean active) throws filmnotfound {
        String query = ("select * from filme where name like \'" + x + "%\' and active=" + active);
        return getFilms(query);
    }

    public ArrayList<Film> findFilmByYear(int year) {
        String query = ("select * from filme where jahr=" + year);
        return getFilms(query);
    }

    public Film insert(Film film) throws filmnotfound {
        String query = ("insert into filme (name ,genre,jahr,regie,active) values(?,?,?,?,?)");
        int id = 0;
        try {
            getConnection().setAutoCommit(false);
            PreparedStatement pre = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pre.setString(1, film.getName());
            pre.setInt(2, film.getGenre());
            pre.setInt(3, film.getJahr());
            pre.setInt(4, film.getRegi());
            pre.setBoolean(5, film.isActive());
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
        return findFilmByName(film.getName());
    }

    @Override
    public Film getFilm(String query) throws filmnotfound {
        Film fi = null;
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                fi = new Film();
                fi.setFilmID(rs.getInt("filmID"));
                fi.setName(rs.getString("name"));
                fi.setGenre(rs.getInt("genre"));
                fi.setJahr(rs.getInt("jahr"));
                fi.setRegi(rs.getInt("regie"));
                fi.setActive(rs.getBoolean("active"));

            } else {
                throw new filmnotfound();
            }
        } catch (SQLException e) {
            System.out.println("fehler");
            e.printStackTrace();
        }

        return fi;
    }

    @Override
    public ArrayList<Film> getFilms(String query) {
        ArrayList<Film> al = null;
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            al = new ArrayList<Film>();
            while (rs.next()) {
                Film fi = new Film();
                fi.setFilmID(rs.getInt("filmID"));
                fi.setName(rs.getString("name"));
                fi.setGenre(rs.getInt("genre"));
                fi.setJahr(rs.getInt("jahr"));
                fi.setRegi(rs.getInt("regie"));
                fi.setActive(rs.getBoolean("active"));
                al.add(fi);

            }
        } catch (SQLException e) {
            System.out.println("fehler");
            e.printStackTrace();
        }
        return al;
    }
}
