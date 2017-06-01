/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.dto;

import java.util.ArrayList;
import java.util.Objects;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import persistence.entities.Schauspieler;

/**
 *
 * @author Nikolay und Don
 */
@Named("Film")
@RequestScoped
public class FilmDTO extends DTO {

    private int filmID;
    private String name;
    private int jahr;
    private GenreDTO genre;
    private ArrayList<UserDTO> users;
    private ArrayList<Schauspieler> schauspieler;
    private RegisseurDTO regisseurDTO;

    public ArrayList<Schauspieler> getSchauspieler() {
        return schauspieler;
    }

    public void setSchauspieler(ArrayList<Schauspieler> schauspieler) {
        this.schauspieler = schauspieler;
    }
    
    

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenreDTO getGenre() {
        return genre;
    }

    public void setGenre(GenreDTO genre) {
        this.genre = genre;
    }

    public int getJahr() {
        return jahr;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }


    public ArrayList<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserDTO> users) {
        this.users = users;
    }

    public RegisseurDTO getRegisseurDTO() {
        return regisseurDTO;
    }

    public void setRegisseurDTO(RegisseurDTO regisseurDTO) {
        this.regisseurDTO = regisseurDTO;
    }    

    @Override
    public String toString() {
        return "FilmDTO{" + "filmID=" + filmID + ", name=" + name + ", jahr=" + jahr + ", genre=" + genre + ", users=" + users + ", schauspieler=" + schauspieler + ", regisseurDTO=" + regisseurDTO + '}';
    }
    



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.filmID;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + this.jahr;
        hash = 97 * hash + Objects.hashCode(this.genre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FilmDTO other = (FilmDTO) obj;
        if (this.filmID != other.filmID) {
            return false;
        }
        if (this.jahr != other.jahr) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
 
}
