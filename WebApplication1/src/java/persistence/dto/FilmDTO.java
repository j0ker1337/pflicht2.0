/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import view.validator.interfaces.IdFilme;

/**
 *
 * @author Nikolay und Don
 */
@ManagedBean
@SessionScoped

public class FilmDTO extends DTO implements Serializable {

    @IdFilme
    private int filmID;
    private String name;
    private int jahr;
    private GenreDTO genre;
    private ArrayList<UserDTO> users;
    private boolean active;
    private ArrayList<SchauspielerDTO> schauspieler;
    private RegisseurDTO regisseurDTO;
    private boolean ihave;

    public FilmDTO() {
    }

    
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ArrayList<SchauspielerDTO> getSchauspieler() {
        return schauspieler;
    }

    public void setSchauspieler(ArrayList<SchauspielerDTO> schauspieler) {
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
        return "FilmDTO{" + "filmID=" + filmID + ", name=" + name + ", jahr=" + jahr + ", genre=" + genre + ", users=" + users + ", active=" + active + ", schauspieler=" + schauspieler + ", regisseurDTO=" + regisseurDTO + ", ihave=" + ihave + '}';
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
        return true;
    }

    public boolean getIhave() {
        return ihave;
    }

    public void setIhave(boolean ihave) {
        this.ihave = ihave;
    }

}
