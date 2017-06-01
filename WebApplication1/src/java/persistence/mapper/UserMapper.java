/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.mapper;

import persistence.entities.User;
import persistence.dto.UserDTO;
import persistence.exceptions.rightsnotfound;
import java.util.ArrayList;

/**
 *
 * @author Nikolay und Don
 */
public class UserMapper {

    public static UserDTO entityToDto(User user) throws rightsnotfound {
        UserDTO udto = new UserDTO();
        udto.setBname(user.getBname());
        udto.setGeburt(user.getGeburt());
        udto.setName(user.getName());
        udto.setPass(user.getPass());
        udto.setId(user.getUserID());
        udto.setVorname(user.getVorname());
        return udto;
    }

    public static User dtoToentity(UserDTO userDto) {
        User user = new User();
        user.setBname(userDto.getBname());
        user.setGeburt(userDto.getGeburt());
        user.setPass(userDto.getPass());
        user.setRightsID(userDto.getRight().getId());
        user.setUserID(userDto.getId());
        user.setVorname(userDto.getVorname());
        user.setName(userDto.getName());
        return user;
    }

    public static ArrayList<UserDTO> entityArrayToDTO(ArrayList<User> users) throws rightsnotfound {
        ArrayList<UserDTO> user = new ArrayList<UserDTO>();
        for (User f : users) {
            user.add(entityToDto(f));
        }
        return user;
    }

    public static ArrayList<User> dtoArrayToentityT(ArrayList<UserDTO> users) throws rightsnotfound {
        ArrayList<User> filme = new ArrayList<User>();
        for (UserDTO f : users) {
            filme.add(dtoToentity(f));
        }
        return filme;
    }
}
