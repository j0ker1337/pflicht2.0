package persistence.connection;
import java.sql.*;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named(value = "dBverbindung")
@Dependent
public class DBverbindung {
private static Connection conn;
    public DBverbindung() {
    }
    
    public static Connection start(){
    final String hostname = "localhost"; 
        final String port = "3306"; 
        final String dbname = "wt123"; 
        final String user = "root"; 
        final String password = ""; 
	
        try { 
	    System.out.println("* Treiber laden"); 
      	    Class.forName("org.gjt.mm.mysql.Driver").newInstance(); 

        } 
        catch (Exception e) { 
            System.err.println("Unable to load driver."); 
            e.printStackTrace(); 

        } 
        try { 
	    System.out.println("* Verbindung aufbauen"); 
	    String url = "jdbc:mysql://"+hostname+":"+port+"/"+dbname; 
	    conn = DriverManager.getConnection(url, user, password); 

        } 
        catch (SQLException sqle) { 
            System.out.println("SQLException: " + sqle.getMessage()); 
            System.out.println("SQLState: " + sqle.getSQLState()); 
            System.out.println("VendorError: " + sqle.getErrorCode()); 
            sqle.printStackTrace(); 

        }
        return conn;
    }
    public static Connection getConnection(){
        if(conn == null){
            conn = start();
        }
        return conn;
    }
}



            
           /* String query = "SELECT * FROM ranking";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
                rs.next();
              int id = rs.getInt("id");
              String firstName = rs.getString("product_name");

              String bla = id+" haha"+firstName;
              return bla;*/