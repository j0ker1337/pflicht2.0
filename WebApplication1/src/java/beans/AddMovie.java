/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import persistence.controlller.controllerManager;
import persistence.dto.FilmDTO;
import persistence.dto.GenreDTO;
import persistence.dto.RegisseurDTO;
import persistence.dto.SchauspielerDTO;
import persistence.exceptions.CombinationNotFound;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.filmnotfound;
import persistence.exceptions.genreNotFound;
import persistence.exceptions.reginotfound;
import persistence.exceptions.rightsnotfound;
import persistence.exceptions.schauspielernotfound;
import persistence.exceptions.usernotfound;
import persistence.exceptions.usersnotfound;
import view.services.UserService;

@Named(value = "addMovie")
@SessionScoped
public class AddMovie implements Serializable {

    private FilmDTO newfilm;
    private HashMap<Integer, SchauspielerDTO> schauspieler;
    private ArrayList<SchauspielerDTO> selectedSchauspieler;
    private ArrayList<SchauspielerDTO> availableSchauspieler;

    public AddMovie() {
        //this.availableSchauspieler = controllerManager.getSchauspielerController().getAllSchauspieler();

        //__________ temp
        this.availableSchauspieler = new ArrayList<SchauspielerDTO>();
        SchauspielerDTO s = new SchauspielerDTO();
        s.setVorname("Gerrit");
        s.setName("Harmes");
        availableSchauspieler.add(s);

        s = new SchauspielerDTO();
        s.setVorname("Halil");
        s.setName("Aydin");
        availableSchauspieler.add(s);

        s = new SchauspielerDTO();
        s.setVorname("Nils");
        s.setName("Nikolay");
        availableSchauspieler.add(s);
        //__________
        selectedSchauspieler = new ArrayList<SchauspielerDTO>();
    }

    public void save(FilmDTO fdto) {
        controllerManager x = FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{controllerManager}", controllerManager.class);
        UserService xxx = FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{USERSE}", UserService.class);
        try {
            x.getFilmController().findFilmByName(fdto.getName());
        } catch (filmnotfound ex) {
            try {
                FilmDTO newfilm = x.getFilmController().insert(fdto);
                xxx.getCurrentUser().getLikes().add(newfilm);
                x.getUserController().likes(xxx.getCurrentUser());
            } catch (filmnotfound ex1) {
                Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (genreNotFound ex1) {
                Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (connectionProblem ex1) {
                Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (rightsnotfound ex1) {
                Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (usernotfound ex1) {
                Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (CombinationNotFound ex1) {
                Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (usersnotfound ex1) {
                Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (reginotfound ex1) {
                Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (genreNotFound ex) {
            Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (connectionProblem ex) {
            Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (usersnotfound ex) {
            Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (rightsnotfound ex) {
            Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (reginotfound ex) {
            Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<SchauspielerDTO> getSelectedSchauspieler() {
        return selectedSchauspieler;
    }

    public void setSelectedSchauspieler(ArrayList<SchauspielerDTO> schauspieler) {
        this.selectedSchauspieler = schauspieler;
    }

    public ArrayList<SchauspielerDTO> getAvailableSchauspieler() {
        return availableSchauspieler;
    }

    public void setAvailableSchauspieler(ArrayList<SchauspielerDTO> schauspieler) {
        this.availableSchauspieler = schauspieler;
    }

    public ArrayList<Integer> getAllYears() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 2017; i >= 1942; i--) {
            list.add(new Integer(i));
        }
        return list;
    }

    public ArrayList<RegisseurDTO> getAllRegi() {
        //return controllerManager.getRegisseurController().getAllRegisser();

        ArrayList<RegisseurDTO> list = new ArrayList<RegisseurDTO>();

        RegisseurDTO temp = new RegisseurDTO();
        temp.setId(0);
        temp.setVorname("Michael");
        temp.setName("Bay");
        list.add(temp);

        temp = new RegisseurDTO();
        temp.setId(1);
        temp.setVorname("Peter");
        temp.setName("Jackson");
        list.add(temp);

        temp = new RegisseurDTO();
        temp.setId(2);
        temp.setVorname("Gerrit");
        temp.setName("Aydin");
        list.add(temp);

        return list;
    }

    public ArrayList<GenreDTO> getAllGenres() {

        //return controllerManager.getGenreController().getAllGenres();
        //TEST---------
//        Genre[] genres = new Genre[3];
//        genres[0]= new Genre();
//        genres[0].setId(0);
//        genres[0].setName("Action");
//        
//        genres[1]= new Genre();
//        genres[1].setId(1);
//        genres[1].setName("SyFy");
//        
//        genres[2]= new Genre();
//        genres[2].setId(2);
//        genres[2].setName("Prono");
        //TEST---------
        ArrayList<GenreDTO> list = new ArrayList<GenreDTO>();

        GenreDTO temp = new GenreDTO();
        temp.setId(0);
        temp.setName("Action");
        list.add(temp);

        temp = new GenreDTO();
        temp.setId(1);
        temp.setName("Prono");
        list.add(temp);

        temp = new GenreDTO();
        temp.setId(2);
        temp.setName("Seifei");
        list.add(temp);

        return list;

    }

    public FilmDTO getNewfilm() {
        return newfilm;
    }

    public void setNewfilm(FilmDTO newfilm) {
        this.newfilm = new FilmDTO();
    }

    public HashMap<Integer, SchauspielerDTO> getsch() {
        HashMap b = new HashMap<Integer, SchauspielerDTO>();
        try {
            controllerManager x = FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{controllerManager}", controllerManager.class);
            for (SchauspielerDTO y : x.getSchauspielerController().findAllSchauspieler()) {
                b.put(y.getId(), y);
            }
            this.schauspieler = b;
        } catch (connectionProblem ex) {
            Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (schauspielernotfound ex) {
            Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return schauspieler;
    }

    public String getSelected() {
        String result = "";
        for (Entry<Integer, SchauspielerDTO> entry : schauspieler.entrySet()) {
            result = result + ", " + entry.getKey();

        }
        return result.toString();
    }

}
