/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.DAO.interfaces;

import java.util.ArrayList;
import persistence.entities.Film;
import persistence.exceptions.filmnotfound;

/**
 *
 * @author joker
 */
public interface filmDao {

    public Film findFilmByName(String name) throws filmnotfound;

    public Film findFilmByName(String name, boolean active) throws filmnotfound;

    public Film findFilmByID(int id) throws filmnotfound;

    public ArrayList<Film> findAllFilm() throws filmnotfound;

    public ArrayList<Film> findAllFilm(boolean active) throws filmnotfound;

    public ArrayList<Film> findSubFilm(String x) throws filmnotfound;

    public ArrayList<Film> findSubFilm(String x, boolean active) throws filmnotfound;

    public Film getFilm(String query) throws filmnotfound;

    public ArrayList<Film> getFilms(String query);

    public Film insert(Film film) throws filmnotfound;
     public ArrayList<Film> findAllFilmsOfYear(int  year) throws filmnotfound;
    
}
