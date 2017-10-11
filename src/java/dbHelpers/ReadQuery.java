
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ships;

public class ReadQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery() {
    
    Properties props = new Properties();
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void doRead() {
        
        try {
            String query = "Select * from stardestroyers";
            
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
   public String getHTMLtable() {
    
       String table = "";
       table += "<table border=1>";
       
        try {
            while(this.results.next()) {
                
                Ships ship = new Ships();
                ship.setShipName(this.results.getString("name"));
                ship.setDateBuilt(this.results.getString("dateBuilt"));
                ship.setFleet(this.results.getString("fleet"));
                ship.setCrewSize(this.results.getInt("crewSize"));
                ship.setCommander(this.results.getString("commander"));
                ship.setStatus(this.results.getString("status"));
                ship.setShipID(this.results.getInt("shipID"));
                
                table += "<tr>";
                    table += "<td>";
                        table += ship.getShipName();
                    table += "</td>";
                
                    table += "<td>";
                        table += ship.getDateBuilt();
                    table += "</td>";
                
                    table += "<td>";
                        table += ship.getFleet();
                    table += "</td>";
                
                    table += "<td>";
                        table += ship.getCrewSize();
                    table += "</td>";
                
                    table += "<td>";
                        table += ship.getCommander();
                    table += "</td>";
                
                    table += "<td>";
                        table += ship.getStatus();
                    table += "</td>";
                
                    table += "<td>";
                        table += ship.getShipID();
                    table += "</td>";
                
                table += "</tr>";
                
            }} catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   
       
       table += "</table>";
       
               return table;
    
   }
   
}   
