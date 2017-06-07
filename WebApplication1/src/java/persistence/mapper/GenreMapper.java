/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.mapper;

import java.util.ArrayList;
import persistence.dto.GenreDTO;
import persistence.entities.Genre;

/**
 *
 * @author Nikolay und Don
 */
public class GenreMapper {

    public static GenreDTO entityToDTO(Genre genre) {
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(genre.getId());
        genreDTO.setName(genre.getName());
        return genreDTO;
    }

    public static Genre dtoToentityT(GenreDTO genreDTO) {
        Genre genre = new Genre();
        genre.setId(genreDTO.getId());
        genre.setName(genreDTO.getName());
        return genre;
    }
    
    public static ArrayList<GenreDTO> entityArrayToDTO(ArrayList<Genre>genres){
        ArrayList<GenreDTO> genre = new ArrayList<GenreDTO>();
        for (Genre f : genres) {
            genre.add(entityToDTO(f));
        }
        return genre;
    }
    
    
        public static ArrayList<Genre> dtoArrayToentityT(ArrayList<GenreDTO>genres){
        ArrayList<Genre> genre = new ArrayList<Genre>();
        for (GenreDTO f : genres) {
            genre.add(dtoToentityT(f));
        }
        return genre;
    }
}
