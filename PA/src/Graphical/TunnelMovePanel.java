package Graphical;

import logicaJogo.Constants;
import logicaJogo.ObservableGame;
import logicaJogo.estados.AwaitTunnelChoice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class TunnelMovePanel extends JPanel implements Observer {

    private ObservableGame game;

    private JButton enterBtn;
    private JButton exitBtn;
    private JButton advanceBtn;
    private JButton fastMovementBtn;


    public TunnelMovePanel(ObservableGame game) {
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
        enterBtn        = new JButton("Enter Tunnel (1 AP)");
        exitBtn         = new JButton("Exit Tunnel (free)");
        advanceBtn      = new JButton("Advance (free or 1 AP)");
        fastMovementBtn = new JButton("FastMovement (1 AP)");

        enterBtn       .addActionListener(new EnterListener());
        exitBtn        .addActionListener(new ExitListener());
        advanceBtn     .addActionListener(new AdvanceListener());
        fastMovementBtn.addActionListener(new FastMovementListener());
    }

    public void setupLayout() {
        Box box = Box.createVerticalBox();
        box.add(Box.createVerticalGlue());
        box.add(enterBtn);
        box.add(Box.createVerticalGlue());
        box.add(exitBtn);
        box.add(Box.createVerticalGlue());
        box.add(advanceBtn);
        box.add(Box.createVerticalGlue());
        box.add(fastMovementBtn);
        box.add(Box.createVerticalGlue());

        setLayout(new BorderLayout());

        add(box, BorderLayout.CENTER);
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getState() instanceof AwaitTunnelChoice);
    }

    public class EnterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.enterTunnel();
        }
    }

    public class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.exitTunnel();
        }
    }

    public class AdvanceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.tunnelMovement();
        }
    }

    public class FastMovementListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.fastMovement();
        }
    }

}
