/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import persistence.DAO.interfaces.rightsDao;
import persistence.entities.Rights;
import persistence.exceptions.rightsnotfound;

/**
 *
 * @author Nikolay und Don
 */
 class rightsDaoImpl extends Dao implements rightsDao{

    @Override
    public Rights findById(int id) throws rightsnotfound {
        String query = "select * from rights where id='" + id + "'";
        return getRights(query);
    }
    
    @Override
    public Rights findRightOfUser(int id) throws rightsnotfound{
        String query = "select r.id,r.`name` from person p join rights r on r.id=p.rightsID where p.userID="+id;
        return getRights(query);
    }

    @Override
    public Rights getRights(String query) throws rightsnotfound {
        Rights rights = null;
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                rights = new Rights();
                rights.setId(rs.getInt("id"));
                rights.setName(rs.getString("name"));
            }
        } catch (SQLException ex) {
            System.err.println("fehler");
        }
        if (rights == null) {
            throw new rightsnotfound();
        }
        return rights;
    }

}
