/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.POJO;

import view.validator.interfaces.Id;
import view.validator.interfaces.IdFilme;
import view.validator.interfaces.IdGenre;
import view.validator.interfaces.NameFilme;
import view.validator.interfaces.StringLenght;

/**
 *
 * @author joker
 */
public class FilmEditPOJO {
    @Id
    @IdFilme
    private int id;
    @StringLenght
    @NameFilme
    private String name;
    
    private int jahr;
    @IdGenre
    @Id
    private int genre;
    private boolean active;
    private int regisseurDTO;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJahr() {
        return jahr;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getRegisseurDTO() {
        return regisseurDTO;
    }

    public void setRegisseurDTO(int regisseurDTO) {
        this.regisseurDTO = regisseurDTO;
    }
    
    
    
    
}
