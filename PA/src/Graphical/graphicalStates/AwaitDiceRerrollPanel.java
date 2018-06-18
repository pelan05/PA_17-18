package Graphical.graphicalStates;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import logicaJogo.Constants;
import logicaJogo.ObservableGame;

public class AwaitDiceRerrollPanel extends JPanel implements Observer, Constants {
    
    private ObservableGame game;
    
    public AwaitDiceRerrollPanel(ObservableGame g){
        game = g;
        
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
