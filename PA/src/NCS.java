import iu.Texto.Interface;
import logicaJogo.ObservavleGame;

public class NCS {

    public static void main(String []args){

        Interface inter = new Interface(new ObservavleGame());

        inter.menuInicial();

    }
}
