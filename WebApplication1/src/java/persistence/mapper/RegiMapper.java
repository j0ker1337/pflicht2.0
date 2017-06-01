/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.mapper;

import java.util.ArrayList;
import persistence.dto.RegisseurDTO;
import persistence.entities.Regisseur;

/**
 *
 * @author joker
 */
public class RegiMapper {
      public static RegisseurDTO entityToDTO(Regisseur regisseur){
        RegisseurDTO regisseurDTO = new RegisseurDTO();
        regisseurDTO.setId(regisseur.getId());
        regisseurDTO.setName(regisseur.getName());
        regisseurDTO.setVorname(regisseur.getVorname());
        return regisseurDTO;
    }
    
    public static Regisseur dtoToentityT(RegisseurDTO regisseurDTO){
        Regisseur regisseur = new Regisseur();
        regisseur.setId(regisseurDTO.getId());
        regisseur.setName(regisseur.getName());
        regisseur.setVorname(regisseurDTO.getVorname());
        return regisseur;
    }
    
    
        public static ArrayList<RegisseurDTO> entityArrayToDTO(ArrayList<Regisseur> regisseur) {
        ArrayList<RegisseurDTO> filme = new ArrayList<RegisseurDTO>();
        for (Regisseur f : regisseur) {
            filme.add(entityToDTO(f));
        }
        return filme;
    }

    public static ArrayList<Regisseur> dtoArrayToentityT(ArrayList<RegisseurDTO> regisseurDTO){
        ArrayList<Regisseur> regisseur = new ArrayList<Regisseur>();
        for (RegisseurDTO f : regisseurDTO) {
            regisseur.add(dtoToentityT(f));
        }
        return regisseur;
    }
}
