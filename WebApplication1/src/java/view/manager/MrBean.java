/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.manager;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author joker
 */
@ManagedBean
@RequestScoped
public class MrBean {
   private String page;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
   
   
}