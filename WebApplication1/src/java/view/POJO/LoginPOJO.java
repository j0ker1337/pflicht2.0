/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.POJO;

import javax.faces.bean.ViewScoped;
import view.validator.interfaces.StringLenght;

/**
 *
 * @author Nikolay und Don
 */
@javax.faces.bean.ManagedBean
@ViewScoped
public class LoginPOJO {

    @StringLenght
    private String username;

    @StringLenght
    private String password;

    public LoginPOJO() {
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
        this.password = password;
    }

}
