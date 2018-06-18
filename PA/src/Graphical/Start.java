package Graphical;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

import logicaJogo.ObservableGame;
import logicaJogo.estados.AwaitBeggining;


public class Start extends JPanel implements Observer {
    
    private ObservableGame game;
    
    private JLabel gameTitle;
    private JButton startBtn;
    
    
    public Start(ObservableGame game) {
        this.game = game;

        gameTitle = new JLabel("9 Card Siege");

        startBtn = new JButton("Start");

        startBtn.addActionListener(new StartListener());

        // add components
        setLayout(new BorderLayout());
        add(gameTitle, BorderLayout.CENTER);
        add(startBtn, BorderLayout.SOUTH);

    }

    //TopBar



    @Override
    public void update(Observable t, Object o) {
        setVisible(game.getState() instanceof AwaitBeggining);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private class StartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.start();
        }
    }
}
