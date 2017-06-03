
package persistence.entities;

import java.sql.Date;

public class User {
    private int userID;
    private String vorname;
    private String name;
    private Date geburt;
    private String Bname;
    private String pass;
    private int rightsID;
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    
    public int getRightsID() {
        return rightsID;
    }

    public void setRightsID(int rightsID) {
        this.rightsID = rightsID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    @Override
    public String toString() {
        return "user{" + "userID=" + userID + ", vorname=" + vorname + ", name=" + name + ", geburt=" + geburt + ", Bname=" + Bname + ", pass=" + pass + ", rightsID=" + rightsID + '}';
    }

  
    
    
}
