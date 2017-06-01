/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.DAO;


/**
 *
 * @author Nikolay und Don
 */
public class DaoManager {
    
    private filmDao fDao;
    private userDao usDao;
    private likefilmDao lDao;
    private genreDao gDao;
    private rightsDao rDao;
    
    public DaoManager() {
        this.fDao=new filmDao();
        this.gDao=new genreDao();
        this.usDao=new userDao();
        this.lDao = new likefilmDao();
        this.rDao = new rightsDao();
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
