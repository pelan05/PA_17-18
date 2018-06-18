package Graphical;

import logicaJogo.Constants;
import logicaJogo.ObservableGame;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import logicaJogo.estados.AwaitBeggining;

public class StatsPanel extends JPanel implements Observer, Constants {

    private ObservableGame game;
    private JLabel statsImage;

    public StatsPanel(ObservableGame g){
        game = g;
        this.game.addObserver(this);

        setupComponents();
        setupLayout();

        update(game, this);
    }

    public void setupComponents(){
        statsImage = new JLabel();
    }

    private void setupLayout(){
        //Makes Panel Transparent
        setBackground(new Color(0,0,0,1));
        setPreferredSize(new Dimension(940, 350));
        add(statsImage);

    }

    @Override
    public void update(Observable t, Object o){
        if( game.getState() instanceof AwaitBeggining)
            setVisible(false);
        else
            setVisible(true);
    }

}
