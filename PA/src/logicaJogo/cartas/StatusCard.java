package logicaJogo.cartas;


public class StatusCard extends Card {

    private row morale;
    private row wall;
    private row supplies;
    private row tunnel;
    private row extraSupplies;

    
    public StatusCard(){
        super();
        this.morale = new row(4, 4);
        this.wall = new row(4, 4);
        this.supplies = new row(4, 4);
        this.tunnel = new row(3, 0);
        this.extraSupplies = new row(2, 0);
    }

    public int getWallStrength() {
        return wall.getValue();
    }

    public int getMorale() {
        return morale.getValue();
    }

    public int getSupplies() {
        return supplies.getValue();
    }

    public int getTunnel() {
        return tunnel.getValue();
    }
        
    public row getExtraSupplies() {
        return extraSupplies;
    }

    public void increaseWall() {
        wall.setValueUp();
    }

    public void increaseMorale() {
        morale.setValueUp();
    }
    public void increaseFortressSupplies() {
        supplies.setValueUp();
    }

    public void decreaseWall() {
        wall.setValueDown();
    }

    public void decreaseMorale() {
        morale.setValueDown();
    }
    public void decreaseFortressSupplies() {
        supplies.setValueDown();
    }

    public void increaseTunnel(){
        if(tunnel.getValue() < tunnel.getSize())
            tunnel.setValueUp();
    }
    public void decreaseTunnel(){
        if(tunnel.getValue() > 0)
            tunnel.setValueDown();
    }
}
