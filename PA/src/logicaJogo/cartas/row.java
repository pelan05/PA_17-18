package logicaJogo.cartas;

public class row {
    private int size;
    private int value;
    private int strength;


    public row(int size, int value){
        this.size = size;
        this.value = value;
    }

    public row(int size, int value, int strength){
        this.size = size;
        this.value = value;
        this.strength = strength;
    }

    public int getSize() {
        return size;
    }

    public int getValue() {
        return value;
    }

    public void setValueUp() {
        if (value < size)
            this.value++;
    }

    public void setValueDown(){
        if (value > 0)
            this.value--;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (strength > 0)
            sb.append("Força: ").append(strength).append("\n");

        sb.append(": ");

            sb.append("[").append( (0 == value)? "X": 0 ).append("] ");

        return sb.toString();
    }
}
