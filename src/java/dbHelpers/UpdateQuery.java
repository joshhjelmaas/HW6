/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ships;

/**
 *
 * @author hjelmaas
 */
public class UpdateQuery {
   
    private Connection conn;
    
    public UpdateQuery() {
        
         Properties props = new Properties();
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }
    
    public void doUpdate (Ships ship) {
        
        try {
            String query = "UPDATE stardestroyers SET name = ?, dateBuilt = ?, fleet = ?, crewSize = ?, commander = ?, status = ? WHERE shipID = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, ship.getShipName());
            ps.setString(2, ship.getDateBuilt());
            ps.setString(3, ship.getFleet());
            ps.setInt(4, ship.getCrewSize());
            ps.setString(5, ship.getCommander());
            ps.setString(6, ship.getStatus());
            ps.setInt(7,ship.getShipID());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
