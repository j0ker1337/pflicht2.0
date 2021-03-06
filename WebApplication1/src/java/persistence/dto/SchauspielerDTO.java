/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.dto;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author joker
 */
@ManagedBean
@SessionScoped
public class SchauspielerDTO implements Serializable {

    private int id;
    private String name;
    private String vorname;
    private ArrayList<FilmDTO> filme;

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

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public ArrayList<FilmDTO> getFilme() {
        return filme;
    }

    public void setFilme(ArrayList<FilmDTO> filme) {
        this.filme = filme;
    }

    @Override
    public String toString() {
        return "SchauspielerDTO{" + "id=" + id + ", name=" + name + ", vorname=" + vorname + ", filme=" + filme + '}';
    }

}
