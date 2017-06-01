
package persistence.entities;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
@ManagedBean
@RequestScoped
public class Film {
    private int filmID;
    private String name;
    private int genre;
    private int jahr;
    private int regi;

    
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
    
    

    @Override
    public String toString() {
        return "film{" + "filmID=" + filmID + ", name=" + name + ", genre=" + genre + ", jahr=" + jahr + ", regi=" + regi + '}';
    }

    public int getRegi() {
        return regi;
    }

    public void setRegi(int regi) {
        this.regi = regi;
    }

}
