package logicaJogo.cartas;

public class row {
    private int size;
    private int value;
<<<<<<< HEAD
    private int strength;

=======
>>>>>>> 126b34bc04a5f4e097d47faf9169315981a2aaef

    public row(int size, int value){
        this.size = size;
        this.value = value;
    }

<<<<<<< HEAD
    public row(int size, int value, int strength){
        this.size = size;
        this.value = value;
        this.strength = strength;
    }

=======
>>>>>>> 126b34bc04a5f4e097d47faf9169315981a2aaef
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
<<<<<<< HEAD


=======
>>>>>>> 126b34bc04a5f4e097d47faf9169315981a2aaef
}
