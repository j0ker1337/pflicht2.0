/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.dto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import view.validator.Unique;

/**
 *
 * @author Nikolay und Don
 */
@ManagedBean
@RequestScoped
public class RegisterDTO {
    
    
    @NotNull
    @Size(min=4,max=100)
    @Unique
    private String benutzername;
    @NotNull
    @Size(min=4,max=100)
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

    public RegisterDTO() {
    }
    
    
    
    
    
    
}
