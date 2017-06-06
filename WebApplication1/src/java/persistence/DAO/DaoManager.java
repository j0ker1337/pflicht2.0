/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.DAO;

import persistence.DAO.interfaces.filmDao;
import persistence.DAO.interfaces.genreDao;
import persistence.DAO.interfaces.likefilmDao;
import persistence.DAO.interfaces.regiDao;
import persistence.DAO.interfaces.rightsDao;
import persistence.DAO.interfaces.schauspielerDao;
import persistence.DAO.interfaces.schauspielerfilmDao;
import persistence.DAO.interfaces.userDao;

/**
 *
 * @author Nikolay und Don
 */
public class DaoManager {

    private filmDaoImpl fDao;
    private userDaoImpl usDao;
    private likefilmDaoImpl lDao;
    private genreDaoImpl gDao;
    private rightsDaoImpl rDao;
    private regiDaoImpl regieDao;
    private schauspielerDaoImpl schauspielerdao;
    private schauspielerfilmDaoImpl schauspielerfilmDao;

    public DaoManager() {
        this.fDao = new filmDaoImpl();
        this.gDao = new genreDaoImpl();
        this.usDao = new userDaoImpl();
        this.lDao = new likefilmDaoImpl();
        this.rDao = new rightsDaoImpl();
        this.schauspielerdao = new schauspielerDaoImpl();
        this.regieDao = new regiDaoImpl();
        this.schauspielerfilmDao = new schauspielerfilmDaoImpl();
    }

    public regiDao getRegieDao() {
        return regieDao;
    }

    public schauspielerDao getSchauspielerdao() {
        return schauspielerdao;
    }

    public schauspielerfilmDao getSchauspielerfilmDao() {
        return schauspielerfilmDao;
    }

    public filmDao getfDao() {
        return fDao;
    }

    public userDao getUsDao() {
        return usDao;
    }

    public likefilmDao getlDao() {
        return lDao;
    }

    public genreDao getgDao() {
        return gDao;
    }

    public rightsDao getrDao() {
        return rDao;
    }

}
