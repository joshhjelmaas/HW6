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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ships;

/**
 *
 * @author hjelmaas
 */
public class ReadRecord {
  
    private Connection conn;
    private ResultSet results;
    
    private Ships ship = new Ships();
    private int shipID;
    
    public ReadRecord (int shipID) {
    Properties props = new Properties();
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
    
    this.shipID = shipID;
    
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void doRead() {
        
        
        try {
            String query = "Select * from stardestroyers where shipID = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, shipID);
        
            this.results = ps.executeQuery();
            
            this.results.next();
            
            ship.setShipName(this.results.getString("name"));
            ship.setDateBuilt(this.results.getString("dateBuilt"));
            ship.setFleet(this.results.getString("fleet"));
            ship.setCrewSize(this.results.getInt("crewSize"));
            ship.setCommander(this.results.getString("commander"));
            ship.setStatus(this.results.getString("status"));
            ship.setShipID(this.results.getInt("shipID"));
        
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
  
    public Ships getShip() {
        
        return this.ship;
        
    }
    
}
    

