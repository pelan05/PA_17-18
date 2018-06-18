package Graphical;

import logicaJogo.ObservableGame;
import logicaJogo.estados.GameOver;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class GameOverPanel extends JPanel implements Observer {

    private ObservableGame game;
    private JLabel label;


    public GameOverPanel(ObservableGame game) {
        this.game = game;
    }

    @Override
    public void update(Observable o, Object o1) {
        setVisible(game.getState() instanceof GameOver);
    }

}
