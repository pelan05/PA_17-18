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
    public void increaseSupplies() {
        supplies.setValueUp();
    }

    public void decreaseWall() {
        wall.setValueDown();
    }

    public void decreaseMorale() {
        morale.setValueDown();
    }
    
    public void decreaseSupplies() {
        supplies.setValueDown();
    }

    public void increaseTunnel(){
        if(tunnel.getValue() < tunnel.getSize())
            tunnel.setValueUp();
    }
    
    public void setTunnel(int val){
        this.tunnel.setValue(val);
    }

    public void resetTunnel(){
        tunnel.setValue(0);
    }

    public void resetExtraSupplies(){
        extraSupplies.setValue(0);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("--> Status Card <--");
        sb.append(morale.toString()).append('\n');
        sb.append(wall.toString()).append('\n');
        sb.append(supplies.toString()).append('\n');
        sb.append(tunnel.toString()).append('\n');
        sb.append(extraSupplies.toString()).append('\n');
        sb.append("--> Status Card <--");

        return sb.toString();
    }
}
