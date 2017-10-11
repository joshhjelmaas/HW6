
package model;


public class Ships {

        private String shipName;
        private String dateBuilt;
        private String fleet;
        private int crewSize;
        private String commander;
        private String status;
        private int shipID;

    public Ships() {
        this.shipName = "";
        this.dateBuilt = "";
        this.fleet = "";
        this.crewSize = 0;
        this.commander = "";
        this.status = "";
        this.shipID = 0;    
    }    
            
    public Ships(String shipName, String dateBuilt, String fleet, int crewSize, String commander, String status, int shipID) {
        this.shipName = shipName;
        this.dateBuilt = dateBuilt;
        this.fleet = fleet;
        this.crewSize = crewSize;
        this.commander = commander;
        this.status = status;
        this.shipID = shipID;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getDateBuilt() {
        return dateBuilt;
    }

    public void setDateBuilt(String dateBuilt) {
        this.dateBuilt = dateBuilt;
    }

    public String getFleet() {
        return fleet;
    }

    public void setFleet(String fleet) {
        this.fleet = fleet;
    }

    public int getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(int crewSize) {
        this.crewSize = crewSize;
    }

    public String getCommander() {
        return commander;
    }

    public void setCommander(String commander) {
        this.commander = commander;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getShipID() {
        return shipID;
    }

    public void setShipID(int shipID) {
        this.shipID = shipID;
    }

    @Override
    public String toString() {
        return "Ships{" + "shipName=" + shipName + ", dateBuilt=" + dateBuilt + ", fleet=" + fleet + ", crewSize=" + crewSize + ", commander=" + commander + ", status=" + status + ", shipID=" + shipID + '}';
    }
    
    
}
