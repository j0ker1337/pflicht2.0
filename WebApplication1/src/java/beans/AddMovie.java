/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import persistence.controlller.controllerManager;
import persistence.dto.GenreDTO;
import persistence.dto.RegisseurDTO;
import persistence.dto.SchauspielerDTO;


@Named(value = "addMovie")
@SessionScoped
public class AddMovie implements Serializable{
    
    private String name;
    private int genre;
    private int jahr;
    private int regi;
    private ArrayList<SchauspielerDTO> schauspieler;

    public ArrayList<SchauspielerDTO> getSchauspieler() {
        return schauspieler;
    }

    public void setSchauspieler(ArrayList<SchauspielerDTO> schauspieler) {
        this.schauspieler = schauspieler;
    }
    
    
    
    public ArrayList<Integer> getAllYears(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i= 2017; i >= 1942; i--){
            list.add(new Integer(i));
        }
        return list;
    }
    
    public ArrayList<RegisseurDTO> getAllRegi(){
        //return controllerManager.getRegisseurController().getAllRegisser();
        
        
        ArrayList<RegisseurDTO> list= new ArrayList<RegisseurDTO>();
        
        RegisseurDTO temp= new RegisseurDTO();
        temp.setId(0);
        temp.setName("Bay");
        list.add(temp);
        
        temp= new RegisseurDTO();
        temp.setId(1);
        temp.setName("Jackson");
        list.add(temp);
        
        temp= new RegisseurDTO();
        temp.setId(2);
        temp.setName("Aydin");
        list.add(temp);
        
        return list;
        
    }
    
    
    
    public ArrayList<GenreDTO> getAllGenres(){
        
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
        
        
        ArrayList<GenreDTO> list= new ArrayList<GenreDTO>();
        
        GenreDTO temp= new GenreDTO();
        temp.setId(0);
        temp.setName("Action");
        list.add(temp);
        
        temp= new GenreDTO();
        temp.setId(1);
        temp.setName("Prono");
        list.add(temp);
        
        temp= new GenreDTO();
        temp.setId(2);
        temp.setName("Seifei");
        list.add(temp);
        
     
        
        return list;
        
    }
    
    
    
    
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public int getJahr() {
        return jahr;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    public int getRegi() {
        return regi;
    }

    public void setRegi(int regi) {
        this.regi = regi;
    }
    
    
    public AddMovie() {
        
    }
    
    public void save(){
        //TODO
    }
    
}
