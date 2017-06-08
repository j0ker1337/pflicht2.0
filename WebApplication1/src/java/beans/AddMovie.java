/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import persistence.controlller.controllerManager;
import persistence.dto.FilmDTO;
import persistence.dto.GenreDTO;
import persistence.dto.RegisseurDTO;
import persistence.dto.SchauspielerDTO;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.genreNotFound;
import persistence.exceptions.reginotfound;
import persistence.exceptions.schauspielernotfound;

@Named(value = "addMovie")
@RequestScoped
public class AddMovie implements Serializable {

    private FilmDTO newfilm;
    private String name;
    private int regi;
    private ArrayList<String> schauspielerids;
    private int genreid;
    private HashMap<Integer, SchauspielerDTO> schauspieler;
    private ArrayList<SchauspielerDTO> selectedSchauspieler;
    private ArrayList<SchauspielerDTO> availableSchauspieler;

    public int getRegi() {
        return regi;
    }

    public void setRegi(int regi) {
        this.regi = regi;
    }

    public ArrayList<String> getSchauspielerids() {
        return schauspielerids;
    }

    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    public void setSchauspielerids(ArrayList<String> schauspielerids) {
        this.schauspielerids = schauspielerids;
    }

    public HashMap<Integer, SchauspielerDTO> getSchauspieler() {
        return schauspieler;
    }

    public void setSchauspieler(HashMap<Integer, SchauspielerDTO> schauspieler) {
        this.schauspieler = schauspieler;
    }

    public AddMovie() {
        schauspielerids = new ArrayList<String>();
        newfilm = new FilmDTO();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void save() {
        try {
            controllerManager x = FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{controllerManager}", controllerManager.class);
            System.err.println(newfilm.getJahr());
            System.err.println(newfilm.getName());
            System.err.println(regi);
            ArrayList<SchauspielerDTO> schauspielerDTOs = new ArrayList<>();
            System.err.println(schauspielerids);
            for (String z : schauspielerids) {
                try {
                    schauspielerDTOs.add(x.getSchauspielerController().findSchauspielerById(Integer.parseInt(z)));
                } catch (schauspielernotfound ex) {
                    Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            newfilm.setSchauspieler(schauspielerDTOs);
            newfilm.setGenre(x.getGenreController().findGenreById(genreid));
            newfilm.setRegisseurDTO(x.getRegieController().findBYId(regi));

            System.err.println(newfilm);
        } catch (connectionProblem ex) {
            Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (reginotfound ex) {
            Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (genreNotFound ex) {
            Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex);
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
        this.newfilm = newfilm;

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

}
