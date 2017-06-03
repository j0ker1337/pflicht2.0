/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.mapper;

import java.util.ArrayList;
import persistence.dto.FilmDTO;
import persistence.entities.Film;
import persistence.exceptions.connectionProblem;
import persistence.exceptions.genreNotFound;

/**
 *
 * @author Nikolay und Don
 */
public class FilmMapper {

    public static FilmDTO entityToDTO(Film film) throws genreNotFound, connectionProblem {
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setFilmID(film.getFilmID());
        filmDTO.setJahr(film.getJahr());
        filmDTO.setName(film.getName());
        filmDTO.setActive(film.isActive());
        return filmDTO;
    }

    public static ArrayList<FilmDTO> entityArrayToDTO(ArrayList<Film> films) throws genreNotFound, connectionProblem {
        ArrayList<FilmDTO> filme = new ArrayList<FilmDTO>();
        for (Film f : films) {
            filme.add(entityToDTO(f));
        }
        return filme;
    }

    public static ArrayList<Film> dtoArrayToentityT(ArrayList<FilmDTO> films) throws genreNotFound, connectionProblem {
        ArrayList<Film> filme = new ArrayList<Film>();
        for (FilmDTO f : films) {
            filme.add(dtoToentityT(f));
        }
        return filme;
    }

    public static Film dtoToentityT(FilmDTO filmDTO) {
        Film film = new Film();
        film.setFilmID(filmDTO.getFilmID());
        film.setGenre(filmDTO.getGenre().getId());
        film.setJahr(filmDTO.getJahr());
        film.setName(filmDTO.getName());
        film.setRegi(filmDTO.getRegisseurDTO().getId());
        film.setActive(filmDTO.isActive());
        return film;
    }
}
