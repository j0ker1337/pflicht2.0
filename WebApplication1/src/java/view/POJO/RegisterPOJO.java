/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.POJO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;
import view.validator.interfaces.StringLenght;
import view.validator.interfaces.UniqueUserName;

/**
 *
 * @author Nikolay und Don
 */
@ManagedBean
@RequestScoped
public class RegisterPOJO {
    
    
    @NotNull
    @StringLenght
    @UniqueUserName
    private String benutzername;
    @NotNull
    @StringLenght
    private String password;

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
    
    
    
    
    
    
}
