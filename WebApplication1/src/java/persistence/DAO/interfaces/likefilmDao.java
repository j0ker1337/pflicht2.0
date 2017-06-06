/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.DAO.interfaces;

import java.util.ArrayList;
import persistence.entities.Film;
import persistence.entities.User;
import persistence.exceptions.CombinationNotFound;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.filmnotfound;
import persistence.exceptions.usernotfound;
import persistence.exceptions.usersnotfound;

/**
 *
 * @author joker
 */
public interface likefilmDao {

    public ArrayList<Film> findFilmsLikedByUser(int id) throws filmnotfound;

    public ArrayList<Film> findFilmsLikedByUser(int id, boolean active) throws filmnotfound;

    public ArrayList<Film> findFilmsLikedByUser(String name, String vorname) throws connectionProblem, usernotfound, filmnotfound;

    public ArrayList<User> findUsersWhoLikesFilm(int id) throws connectionProblem, usersnotfound;

    public ArrayList<User> findUsersWhoLikesFilm(int id, boolean active) throws connectionProblem, usersnotfound;

    public ArrayList<User> findUsersWhoLikesFilm(String name) throws filmnotfound, connectionProblem, usersnotfound;

    public ArrayList<User> findUsersWhoLikesFilm(String name, boolean active) throws filmnotfound, connectionProblem, usersnotfound;

    public Film findCombination(int userid, int filmid) throws CombinationNotFound;

    public Film delete(int userid, int filmid) throws filmnotfound, CombinationNotFound, connectionProblem;

    public Film insert(int userid, int filmid) throws filmnotfound, CombinationNotFound, connectionProblem;

    public Film updateQuery(String query, int userid, int filmid) throws filmnotfound, CombinationNotFound, connectionProblem;
}
