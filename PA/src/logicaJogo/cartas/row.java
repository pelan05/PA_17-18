package logicaJogo.cartas;

public class row {
    private int size;
    private int value;

    public row(int size, int value){
        this.size = size;
        this.value = value;
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
}
