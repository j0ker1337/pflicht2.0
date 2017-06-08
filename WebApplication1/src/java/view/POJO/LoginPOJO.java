/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.POJO;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import view.validator.interfaces.StringLenght;
import view.validator.interfaces.UserNameNotFound;

@ManagedBean
@SessionScoped
public class LoginPOJO implements Serializable {

    @StringLenght
    @UserNameNotFound
    private String username;

    @StringLenght
    private String password;

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
