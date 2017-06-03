/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.dto;

import java.sql.Date;
import java.util.ArrayList;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Nikolay und Don
 */
@Named("User")
@RequestScoped
public class UserDTO extends DTO{
   private int id;
   private String vorname;
    private String name;
    private Date geburt;
    private String Bname;
    private String pass;
    private RightDTO right;
    private boolean active;
    private ArrayList<FilmDTO> likes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getGeburt() {
        return geburt;
    }

    public void setGeburt(Date geburt) {
        this.geburt = geburt;
    }

    public String getBname() {
        return Bname;
    }

    public void setBname(String Bname) {
        this.Bname = Bname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public RightDTO getRight() {
        return right;
    }

    public void setRight(RightDTO right) {
        this.right = right;
    }

    public ArrayList<FilmDTO> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<FilmDTO> likes) {
        this.likes = likes;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + id + ", vorname=" + vorname + ", name=" + name + ", geburt=" + geburt + ", Bname=" + Bname + ", pass=" + pass + ", right=" + right + ", active=" + active + ", likes=" + likes + '}';
    }

    
   
    
    
    
}
