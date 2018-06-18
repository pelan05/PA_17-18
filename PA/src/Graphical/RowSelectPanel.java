package Graphical;

import logicaJogo.Constants;
import logicaJogo.ObservableGame;
import logicaJogo.estados.AwaitTrackDirection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class RowSelectPanel extends JPanel implements Observer {

    private ObservableGame game;

    private JButton ladderBtn;
    private JButton ramBtn;
    private JButton siegeBtn;

    public RowSelectPanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);

        Dimension d = new Dimension(
                Constants.GAP_X_CARD + Constants.DIM_X_CARD + Constants.GAP_X_CARD,
                Constants.GAP_Y_CARD + Constants.DIM_Y_CARD + Constants.GAP_X_CARD
        );

        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setBackground(Color.yellow);

        setupComponents();
        setupLayout();
    }

    public void setupComponents() {
        ladderBtn = new JButton("Ladders");
        ladderBtn.addActionListener(new SelectWallListener());

        ramBtn = new JButton("Ram");
        ramBtn.addActionListener(new SelectGatesListener());

        siegeBtn = new JButton("Siege Tower");
        siegeBtn.addActionListener(new SelectTrebuListener());
    }

    public void setupLayout() {
        Box box = Box.createVerticalBox();
        box.add(Box.createVerticalGlue());

        box.add(ladderBtn);
        box.add(Box.createVerticalGlue());
        box.add(ramBtn);
        box.add(Box.createVerticalGlue());
        box.add(siegeBtn);
        box.add(Box.createVerticalGlue());

        setLayout(new BorderLayout());
        add(box, BorderLayout.CENTER);
    }


    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getState() instanceof AwaitTrackDirection);
    }

    private static class SelectWallListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
        }
    }

    private static class SelectGatesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
        }
    }

    private static class SelectTrebuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
        }
    }
}
