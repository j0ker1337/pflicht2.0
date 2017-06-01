/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.dto;

import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Size;

/**
 *
 * @author Nikolay und Don
 */
@javax.faces.bean.ManagedBean
@ViewScoped
public class LoginDTO {
        
    @Size(min=4,max=100)
    private String username;

    @Size(min=4,max=100)
    private String password;


    public LoginDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }
   

}
