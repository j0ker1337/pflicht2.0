/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.controlller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.DAO.DaoManager;
import persistence.controlller.interfaces.Controller;
import persistence.dto.FilmDTO;
import persistence.dto.GenreDTO;
import persistence.dto.RegisseurDTO;
import persistence.dto.RightDTO;
import persistence.dto.SchauspielerDTO;
import persistence.dto.UserDTO;
import persistence.entities.Film;
import persistence.entities.User;
import persistence.exceptions.CombinationNotFound;
import persistence.exceptions.RightIdEmpty;
import persistence.exceptions.UserBNameEmpty;
import persistence.exceptions.UserEmpty;
import persistence.exceptions.UserFoundException;
import persistence.exceptions.UserIdEmpty;
import persistence.exceptions.absteigendoneminusoneorzero;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.filmnotfound;
import persistence.exceptions.genreNotFound;
import persistence.exceptions.reginotfound;
import persistence.exceptions.rightsnotfound;
import persistence.exceptions.schauspielernotfound;
import persistence.exceptions.usernotfound;
import persistence.exceptions.usersnotfound;
import persistence.mapper.FilmMapper;
import persistence.mapper.GenreMapper;
import persistence.mapper.RegiMapper;
import persistence.mapper.RightsMapper;
import persistence.mapper.SchauspielerMapper;
import persistence.mapper.UserMapper;
import util.checker.userCheck;

/**
 *
 * @author Nikolay und Don
 */
public class ControllerImpl implements Controller {

    private final DaoManager daoManager;

    public ControllerImpl() {
        daoManager = new DaoManager();
    }

    @Override
    public FilmDTO findFilmByName(String name) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound, reginotfound {
        FilmDTO dTO = FilmMapper.entityToDTO(daoManager.getfDao().findFilmByName(name));
        return buildFilmObject(dTO.getFilmID());
    }

    public GenreDTO findGenreOfFilm(int id) throws genreNotFound, connectionProblem {
        return GenreMapper.entityToDTO(daoManager.getgDao().findGenreByFilmID(id));
    }

    public RegisseurDTO findRegisseurwhoCreatedFilm(int id) throws connectionProblem, reginotfound {

        return RegiMapper.entityToDTO(daoManager.getRegieDao().findRegisseurwhoCreatedFilm(id));
    }

    @Override
    public FilmDTO findFilmByID(int id) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound, reginotfound {
        FilmDTO dTO = FilmMapper.entityToDTO(daoManager.getfDao().findFilmByID(id));
        return buildFilmObject(dTO.getFilmID());
    }

    @Override
    public ArrayList<FilmDTO> findAllFilm() throws filmnotfound, genreNotFound, connectionProblem, rightsnotfound, reginotfound {
        ArrayList<Film> filmsDTO = daoManager.getfDao().findAllFilm();
        ArrayList<FilmDTO> films = new ArrayList<>();
        for (Film x : filmsDTO) {
            try {
                films.add(buildFilmObject(x.getFilmID()));
            } catch (usersnotfound ex) {
                Logger.getLogger(ControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return films;
    }

    @Override
    public GenreDTO findGenreByFilmID(int id) throws genreNotFound, connectionProblem {
        return GenreMapper.entityToDTO(daoManager.getgDao().findGenreByFilmID(id));
    }

    @Override
    public ArrayList<FilmDTO> findSubFilm(String x) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound, reginotfound {
        ArrayList<Film> films = daoManager.getfDao().findSubFilm(x);
        ArrayList<FilmDTO> filmsDTO = new ArrayList<>();
        for (Film y : films) {
            filmsDTO.add(buildFilmObject(y.getFilmID()));
        }
        return filmsDTO;
    }

    @Override
    public GenreDTO findGenreById(int id) throws genreNotFound, connectionProblem {
        return GenreMapper.entityToDTO(daoManager.getgDao().findById(id));
    }

    @Override
    public GenreDTO findGenreByName(String name) throws genreNotFound, connectionProblem {
        return GenreMapper.entityToDTO(daoManager.getgDao().findByName(name));
    }

    @Override
    public ArrayList<FilmDTO> findFilmsLikedByUser(int id) throws filmnotfound, genreNotFound, connectionProblem, reginotfound {
        ArrayList<Film> likesArrayList = daoManager.getlDao().findFilmsLikedByUser(id);
        ArrayList<FilmDTO> films = FilmMapper.entityArrayToDTO(likesArrayList);
        for (FilmDTO x : films) {
            x.setGenre(findGenreByFilmID(x.getFilmID()));
            x.setRegisseurDTO(findRegisseurwhoCreatedFilm(x.getFilmID()));
            x.setSchauspieler(findSchauspielerOfFilm(x.getFilmID()));
        }
        return films;
    }

    @Override
    public ArrayList<FilmDTO> findFilmLikedByPerson(String name, String vorname) throws connectionProblem, usernotfound, filmnotfound, genreNotFound, reginotfound {
        ArrayList<FilmDTO> films = FilmMapper.entityArrayToDTO(daoManager.getlDao().findFilmsLikedByUser(name, vorname));
        for (FilmDTO x : films) {
            x.setGenre(findGenreByFilmID(x.getFilmID()));
            x.setRegisseurDTO(findRegisseurwhoCreatedFilm(x.getFilmID()));

        }
        return films;
    }

    @Override
    public ArrayList<SchauspielerDTO> findSchauspielerOfFilm(int id) throws connectionProblem {
        return SchauspielerMapper.entityArrayToDTO(daoManager.getSchauspielerfilmDao().findSchaupielerWhoPlayedInFilm(id));
    }

    @Override
    public ArrayList<UserDTO> findUsersWhoLikesFilm(int id) throws connectionProblem, usersnotfound, rightsnotfound {
        return UserMapper.entityArrayToDTO(daoManager.getlDao().findUsersWhoLikesFilm(id));
    }

    @Override
    public ArrayList<UserDTO> findpersonsLikesFilm(String name) throws filmnotfound, connectionProblem, usersnotfound, rightsnotfound {
        ArrayList<UserDTO> users = UserMapper.entityArrayToDTO(daoManager.getlDao().findUsersWhoLikesFilm(name));
        for (UserDTO x : users) {
            x.setRight(findRightOfUser(x.getId()));
        }
        return null;
    }

    @Override
    public RightDTO findRightsById(int id) throws rightsnotfound {
        return RightsMapper.entityToDTO(daoManager.getrDao().findById(id));
    }

    @Override
    public UserDTO findUserByName(String name, String vorname) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound, reginotfound {
        UserDTO udto = UserMapper.entityToDto(daoManager.getUsDao().findUserByName(name, vorname));
        udto.setLikes(findFilmsLikedByUser(udto.getId()));
        return udto;
    }

    @Override
    public UserDTO findUserByID(int id) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound, reginotfound {
        UserDTO udto = UserMapper.entityToDto(daoManager.getUsDao().findUserByID(id));
        ArrayList<FilmDTO> likes;
        likes = findFilmsLikedByUser(udto.getId());
        udto.setLikes(likes);
        udto.setRight(findRightOfUser(udto.getId()));
        return udto;
    }

    @Override
    public UserDTO findUserByUserName(String name) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound, reginotfound {
        UserDTO udto = UserMapper.entityToDto(daoManager.getUsDao().findUserByUserName(name));
        udto.setLikes(findFilmsLikedByUser(udto.getId()));
        udto.setRight(findRightOfUser(udto.getId()));
        return udto;
    }

    @Override
    public ArrayList<UserDTO> findAllUser() throws connectionProblem, usersnotfound, rightsnotfound, filmnotfound, genreNotFound, reginotfound {
        ArrayList<UserDTO> udto = UserMapper.entityArrayToDTO(daoManager.getUsDao().findAllUser());
        for (UserDTO x : udto) {
            x.setRight(findRightOfUser(x.getId()));
            x.setLikes(findFilmsLikedByUser(x.getId()));
        }
        return udto;
    }

    @Override
    public RightDTO findRightOfUser(int id) throws rightsnotfound {
        return RightsMapper.entityToDTO(daoManager.getrDao().findRightOfUser(id));
    }

    @Override
    public UserDTO update(UserDTO udto) throws UserEmpty, UserIdEmpty, rightsnotfound, RightIdEmpty, UserBNameEmpty, connectionProblem {
        User x = UserMapper.dtoToentity(udto);
        try {
            userCheck.checkforUpdateUser(x, daoManager);
        } catch (usernotfound ex) {
            return UserMapper.entityToDto(daoManager.getUsDao().update(UserMapper.dtoToentity(udto)));
        } catch (UserFoundException ex) {
            Logger.getLogger(ControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public UserDTO likes(UserDTO userdto) throws connectionProblem, usernotfound, rightsnotfound, filmnotfound, genreNotFound, CombinationNotFound, usersnotfound, reginotfound {
        UserDTO old = findUserByID(userdto.getId());
        Film x = null;
        checker1(old.getLikes(), userdto.getLikes(), userdto.getId());

        return findUserByID(userdto.getId());
    }

    public void checker1(ArrayList<FilmDTO> oldl, ArrayList<FilmDTO> newl, int userid) throws filmnotfound, connectionProblem, CombinationNotFound {
        if (newl.size() == oldl.size() && equals(oldl, newl)) {

        } else if (oldl.size() >= newl.size()) {
            Iterator itr = oldl.iterator();
            while (itr.hasNext()) {
                FilmDTO x = (FilmDTO) itr.next();
                if (!newl.contains(x)) {
                    daoManager.getlDao().delete(userid, x.getFilmID());
                    itr.remove();
                    oldl.remove(x);
                }
            }
            checker1(oldl, newl, userid);
        } else if (oldl.size() <= newl.size()) {
            Iterator itr = newl.iterator();
            while (itr.hasNext()) {
                FilmDTO x = (FilmDTO) itr.next();
                if (!oldl.contains(x)) {
                    daoManager.getlDao().insert(userid, x.getFilmID());
                    oldl.add(x);
                }

            }
            checker1(oldl, newl, userid);
        }

    }

    private boolean equals(ArrayList<FilmDTO> x, ArrayList<FilmDTO> y) {
        boolean h = true;
        for (FilmDTO d : x) {
            if (!y.contains(d)) {
                h = false;
            }
        }
        return h;
    }

    @Override
    public ArrayList<FilmDTO> getSortedFilmsByLike(int absteigend, int anz) throws filmnotfound, genreNotFound, connectionProblem, absteigendoneminusoneorzero, rightsnotfound, reginotfound {
        if (absteigend > 1 || absteigend < -1) {
            throw new absteigendoneminusoneorzero();
        }
        ArrayList<FilmDTO> films = findAllFilm();
        Collections.sort(films, new Comparator<FilmDTO>() {
            @Override
            public int compare(FilmDTO first, FilmDTO o) {
                if (first.getUsers().size() == ((FilmDTO) o).getUsers().size()) {
                    return 0;
                }
                if (first.getUsers().size() < ((FilmDTO) o).getUsers().size()) {
                    return absteigend;
                } else {
                    return (-1) * (absteigend);
                }
            }

        });
        ArrayList<FilmDTO> newfilms = new ArrayList<>();
        int i = 0;
        for (FilmDTO fi : films) {
            if (i < anz) {
                newfilms.add(fi);
                i++;
            }
        }
        return newfilms;
    }

    @Override
    public ArrayList<FilmDTO> getSortedFilmsByLike(int absteigend) throws filmnotfound, genreNotFound, connectionProblem, absteigendoneminusoneorzero, rightsnotfound, reginotfound {
        if (absteigend > 1 || absteigend < -1) {
            throw new absteigendoneminusoneorzero();
        }
        ArrayList<FilmDTO> films;
        films = findAllFilm();
        Collections.sort(films, new Comparator<FilmDTO>() {
            @Override
            public int compare(FilmDTO first, FilmDTO o) {
                if (first.getUsers().size() == ((FilmDTO) o).getUsers().size()) {
                    return 0;
                }
                if (first.getUsers().size() < ((FilmDTO) o).getUsers().size()) {
                    return absteigend;
                } else {
                    return (-1) * (absteigend);
                }
            }

        });
        return films;
    }

    @Override
    public UserDTO save(UserDTO udto) throws connectionProblem, rightsnotfound, usernotfound, usernotfound, UserBNameEmpty, UserEmpty, UserFoundException, RightIdEmpty {
        User x = UserMapper.dtoToentity(udto);
        userCheck.checkforSaveUser(UserMapper.dtoToentity(udto), daoManager);
        return UserMapper.entityToDto(daoManager.getUsDao().insert(x));
    }

    private FilmDTO buildFilmObject(int filmid) throws genreNotFound, connectionProblem, usersnotfound, rightsnotfound, reginotfound, filmnotfound {
        FilmDTO dTO = FilmMapper.entityToDTO(daoManager.getfDao().findFilmByID(filmid));
        dTO.setUsers(findUsersWhoLikesFilm(dTO.getFilmID()));
        dTO.setRegisseurDTO(findRegisseurwhoCreatedFilm(dTO.getFilmID()));
        dTO.setGenre(findGenreOfFilm(dTO.getFilmID()));
        dTO.setSchauspieler(findSchauspielerOfFilm(dTO.getFilmID()));
        return dTO;
    }

    @Override
    public FilmDTO findFilmByName(String name, boolean active) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound, reginotfound {
        FilmDTO dTO = FilmMapper.entityToDTO(daoManager.getfDao().findFilmByName(name, active));
        return buildFilmObject(dTO.getFilmID());
    }

    @Override
    public ArrayList<FilmDTO> findSubFilm(String x, boolean active) throws filmnotfound, genreNotFound, connectionProblem, usersnotfound, rightsnotfound, reginotfound {
        ArrayList<Film> films = daoManager.getfDao().findSubFilm(x, active);
        ArrayList<FilmDTO> filmsDTO = new ArrayList<>();
        for (Film y : films) {
            filmsDTO.add(buildFilmObject(y.getFilmID()));
        }
        return filmsDTO;
    }

    @Override
    public ArrayList<UserDTO> findAllUser(boolean active) throws connectionProblem, usersnotfound, rightsnotfound, filmnotfound, genreNotFound, reginotfound {
        ArrayList<UserDTO> udto = UserMapper.entityArrayToDTO(daoManager.getUsDao().findAllUser(active));
        for (UserDTO x : udto) {
            x.setRight(findRightOfUser(x.getId()));
            x.setLikes(findFilmsLikedByUser(x.getId()));
        }
        return udto;
    }

    @Override
    public ArrayList<FilmDTO> findFilmsLikedByUser(int id, boolean active) throws filmnotfound, genreNotFound, connectionProblem, reginotfound {
        ArrayList<Film> likesArrayList = daoManager.getlDao().findFilmsLikedByUser(id, active);
        ArrayList<FilmDTO> films = FilmMapper.entityArrayToDTO(likesArrayList);
        for (FilmDTO x : films) {
            x.setGenre(findGenreByFilmID(x.getFilmID()));
            x.setRegisseurDTO(findRegisseurwhoCreatedFilm(x.getFilmID()));
            x.setSchauspieler(findSchauspielerOfFilm(x.getFilmID()));
        }
        return films;
    }

    @Override
    public ArrayList<UserDTO> findUsersWhoLikesFilm(int id, boolean active) throws connectionProblem, usersnotfound, rightsnotfound {
        return UserMapper.entityArrayToDTO(daoManager.getlDao().findUsersWhoLikesFilm(id, active));
    }

    @Override
    public ArrayList<UserDTO> findpersonsLikesFilm(String name, boolean active) throws filmnotfound, connectionProblem, usersnotfound, rightsnotfound {
        ArrayList<UserDTO> users = UserMapper.entityArrayToDTO(daoManager.getlDao().findUsersWhoLikesFilm(name, active));
        for (UserDTO x : users) {
            x.setRight(findRightOfUser(x.getId()));
        }
        return null;
    }

    @Override
    public ArrayList<FilmDTO> getSortedFilmsByLike(int absteigend, int anz, boolean active) throws filmnotfound, genreNotFound, connectionProblem, absteigendoneminusoneorzero, rightsnotfound, reginotfound {
        if (absteigend > 1 || absteigend < -1) {
            throw new absteigendoneminusoneorzero();
        }
        ArrayList<FilmDTO> films = findAllFilm(active);
        Collections.sort(films, new Comparator<FilmDTO>() {
            @Override
            public int compare(FilmDTO first, FilmDTO o) {
                if (first.getUsers().size() == ((FilmDTO) o).getUsers().size()) {
                    return 0;
                }
                if (first.getUsers().size() < ((FilmDTO) o).getUsers().size()) {
                    return absteigend;
                } else {
                    return (-1) * (absteigend);
                }
            }

        });
        ArrayList<FilmDTO> newfilms = new ArrayList<>();
        int i = 0;
        for (FilmDTO fi : films) {
            if (i < anz) {
                newfilms.add(fi);
                i++;
            }
        }
        return newfilms;
    }

    @Override
    public ArrayList<FilmDTO> getSortedFilmsByLike(int absteigend, boolean active) throws filmnotfound, genreNotFound, connectionProblem, absteigendoneminusoneorzero, rightsnotfound, reginotfound {
        if (absteigend > 1 || absteigend < -1) {
            throw new absteigendoneminusoneorzero();
        }
        ArrayList<FilmDTO> films;
        films = findAllFilm(active);
        Collections.sort(films, new Comparator<FilmDTO>() {
            @Override
            public int compare(FilmDTO first, FilmDTO o) {
                if (first.getUsers().size() == ((FilmDTO) o).getUsers().size()) {
                    return 0;
                }
                if (first.getUsers().size() < ((FilmDTO) o).getUsers().size()) {
                    return absteigend;
                } else {
                    return (-1) * (absteigend);
                }
            }

        });
        return films;
    }

    @Override
    public ArrayList<FilmDTO> findAllFilm(boolean active) throws filmnotfound, genreNotFound, connectionProblem, rightsnotfound, reginotfound {
        ArrayList<Film> filmsDTO = daoManager.getfDao().findAllFilm(active);
        ArrayList<FilmDTO> films = new ArrayList<>();
        for (Film x : filmsDTO) {
            try {
                films.add(buildFilmObject(x.getFilmID()));
            } catch (usersnotfound ex) {
                Logger.getLogger(ControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return films;
    }

    public boolean delete(UserDTO userdto) throws connectionProblem, usernotfound {
        return daoManager.getUsDao().delete(userdto.getId());
    }

    @Override
    public ArrayList<GenreDTO> getAllGenre() throws connectionProblem {
        return GenreMapper.entityArrayToDTO(daoManager.getgDao().findAllGenre());
    }
    
    
    public ArrayList<RegisseurDTO> getAllRegisseur() throws reginotfound, connectionProblem{
        return RegiMapper.entityArrayToDTO(daoManager.getRegieDao().findAllRegisseur());
    }

    @Override
    public SchauspielerDTO findSchauspielerById(int id) throws connectionProblem, schauspielernotfound {
       return SchauspielerMapper.entityToDTO(daoManager.getSchauspielerdao().findSchauspielerById(id));
    }

    @Override
    public SchauspielerDTO delte(int id) throws connectionProblem {
        return SchauspielerMapper.entityToDTO(daoManager.getSchauspielerdao().delte(id));
    }

    @Override
    public SchauspielerDTO insert(SchauspielerDTO schauspieler) throws connectionProblem, schauspielernotfound {
        return SchauspielerMapper.entityToDTO(daoManager.getSchauspielerdao().insert(SchauspielerMapper.dtoToentityT(schauspieler)));
    }

    @Override
    public ArrayList<SchauspielerDTO> findAllSchauspieler() throws connectionProblem, schauspielernotfound {
        return SchauspielerMapper.entityArrayToDTO(daoManager.getSchauspielerdao().findAllSchauspieler());
    }
    
    @Override
    public FilmDTO insert(FilmDTO film) throws filmnotfound, genreNotFound, connectionProblem{
        return FilmMapper.entityToDTO(daoManager.getfDao().insert(FilmMapper.dtoToentityT(film)));
    }

}
