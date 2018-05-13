import iu.Texto.Interface;
import logicaJogo.ObservableGame;

public class NCS {

    public static void main(String []args){

        Interface inter = new Interface(new ObservableGame());

        inter.menuInicial();

    }
}
