package persistence.controlller.impl;


import persistence.exceptions.connectionProblem;
import persistence.exceptions.genreNotFound;
import persistence.controlller.impl.ControllerImpl;
import persistence.controlller.interfaces.GenreController;
import persistence.dto.GenreDTO;
import javax.enterprise.context.Dependent;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Nikolay und Don
 */

@Named(value = "genreController")
@Dependent
@RequestScoped
public class GenreControllerImpl extends ControllerImpl implements GenreController {

    @Override
    public GenreDTO findGenreByName(String name) throws genreNotFound, connectionProblem {
        return super.findGenreByName(name);
    }

    @Override
    public GenreDTO findGenreById(int id) throws genreNotFound, connectionProblem {
        return super.findGenreById(id); 
    }
    
}
