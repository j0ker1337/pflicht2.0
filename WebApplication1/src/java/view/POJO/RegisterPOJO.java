/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.POJO;




import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;
import view.validator.interfaces.StringLenght;
import view.validator.interfaces.UniqueUserName;

/** 
 *
 * @author Nikolay und Don
 */
@ManagedBean
@SessionScoped
public class RegisterPOJO implements Serializable{

    @NotNull
    @UniqueUserName
    private String benutzername;
    
    @NotNull
    @StringLenght
    private String password;

    private String vorname;
    private String nachname;

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RegisterPOJO() {
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

}
