package persistence.controlller;

import java.util.ArrayList;
import persistence.controlller.interfaces.Controller;
import persistence.controlller.interfaces.GenreController;
import persistence.dto.GenreDTO;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.genreNotFound;

/**
 *
 * @author Nikolay und Don
 */
class GenreControllerImpl implements GenreController {

    private Controller controller;

    public GenreControllerImpl(Controller controller) {
        this.controller = controller;
    }

    @Override
    public GenreDTO findGenreByName(String name) throws genreNotFound, connectionProblem {
        return controller.findGenreByName(name);
    }

    @Override
    public GenreDTO findGenreById(int id) throws genreNotFound, connectionProblem {
        return controller.findGenreById(id);
    }
    
     public ArrayList<GenreDTO> getAllGenre() throws connectionProblem{
         return controller.getAllGenre();
     }

}
