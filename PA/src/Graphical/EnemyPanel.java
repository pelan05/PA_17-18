package Graphical;

import logicaJogo.Constants;
import logicaJogo.ObservableGame;
import logicaJogo.estados.*;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class EnemyPanel extends JPanel implements Observer, Constants {
    private ObservableGame game;
    private JLabel dungeonImage;


    public EnemyPanel(ObservableGame g){
        game = g;
        this.game.addObserver(this);

        setupComponents();
        setupLayout();

        update(game, this);
    }

    public void setupComponents(){
        dungeonImage = new JLabel("");
    }

    private void setupLayout(){
        setPreferredSize(new Dimension(360, 505));
        add(dungeonImage);
    }

    @Override
    public void update(Observable t, Object o){
        if( game.getState() instanceof AwaitBeggining ||
                game.getState() instanceof AwaitTopCard ||
                game.getState() instanceof AwaitPlayerAction )
            setVisible(false);
        else
            setVisible(true);

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
}
