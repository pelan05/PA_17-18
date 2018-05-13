package logicaJogo.cartas;

public class EnemyCard extends Card{

    private row ladders;
    private row rams;
    private row tower;
    private row trebuchet;

    public EnemyCard(){
        super();

        this.ladders = new row(4,4, 2);
        this.rams = new row(4,4, 3);
        this.tower = new row(4, 4, 4);
        this.trebuchet = new row(3, 3);
    }

    public int getLadders() {
        return ladders.getValue();
    }

    public void advanceLadder() {
        ladders.setValueDown();
    }

    public int getRams() {
        return rams.getValue();
    }

    public void advanceRams() {
        rams.setValueDown();
    }

    public int getTower() {
        return tower.getValue();
    }

    public void advanceTower() {
        tower.setValueDown();
    }

    public int getTrebuchets() {
        return trebuchet.getValue();
    }

    public int checkCCA() {
        int enemiesInCCA = 0;
        if (ladders.getValue() == 0) enemiesInCCA++;
        if (rams.getValue() == 0) enemiesInCCA++;
        if (tower.getValue() == 0) enemiesInCCA++;

        return enemiesInCCA;
    }

    public void removeTower(){
        tower = null;
    }

    public row getRow(int n) {
        switch (n) {
            case 0: return ladders;
            case 1: return rams;
            case 2: return tower;
        }

        return null;
    }

    public int inCircleSpace(row ROW){
        return ROW.getValue();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("\n--> Enemy Card <--\n");
        sb.append("Ladders: ").append(ladders.toString()).append('\n');
        sb.append("Rams: ").append(rams.toString()).append('\n');
        sb.append("Tower: ").append(tower.toString()).append('\n');
        sb.append("Trebuchet: ").append(trebuchet.toString()).append('\n');
        sb.append("--> Enemy Card <--\n");

        return sb.toString();
    }
}