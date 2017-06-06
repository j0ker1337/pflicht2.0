/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.mapper;

import java.util.ArrayList;
import persistence.dto.SchauspielerDTO;
import persistence.entities.Schauspieler;

/**
 *
 * @author joker
 */
public class SchauspielerMapper {

    public static SchauspielerDTO entityToDTO(Schauspieler schauspieler) {
        SchauspielerDTO schauspielerDTO = new SchauspielerDTO();
        schauspielerDTO.setId(schauspieler.getId());
        schauspielerDTO.setName(schauspieler.getName());
        schauspielerDTO.setVorname(schauspieler.getVorname());
        return schauspielerDTO;
    }

    public static Schauspieler dtoToentityT(SchauspielerDTO schauspielerDTO) {
        Schauspieler schauspieler = new Schauspieler();
        schauspieler.setId(schauspielerDTO.getId());
        schauspieler.setName(schauspieler.getName());
        schauspieler.setVorname(schauspielerDTO.getVorname());
        return schauspieler;
    }

    public static ArrayList<SchauspielerDTO> entityArrayToDTO(ArrayList<Schauspieler> schauspieler) {
        ArrayList<SchauspielerDTO> filme = new ArrayList<SchauspielerDTO>();
        for (Schauspieler f : schauspieler) {
            filme.add(entityToDTO(f));
        }
        return filme;
    }

    public static ArrayList<Schauspieler> dtoArrayToentityT(ArrayList<SchauspielerDTO> schauspielerDTO) {
        ArrayList<Schauspieler> schauspieler = new ArrayList<Schauspieler>();
        for (SchauspielerDTO f : schauspielerDTO) {
            schauspieler.add(dtoToentityT(f));
        }
        return schauspieler;
    }
}
