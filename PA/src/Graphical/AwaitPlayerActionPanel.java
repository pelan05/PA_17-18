package Graphical;

import logicaJogo.Constants;
import logicaJogo.ObservableGame;
import logicaJogo.estados.AwaitPlayerAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class AwaitPlayerActionPanel extends JPanel implements Observer {

    private ObservableGame game;

    private JButton archersAtk;
    private JButton boilingWaterAtk;
    private JButton ccaAtk;
    private JButton coupure;
    private JButton rally;
    private JButton tunnelMov;
    private JButton supplyRaid;
    private JButton sabotage;
    private JButton endTurn;


    public AwaitPlayerActionPanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);


        Dimension d = new Dimension(Constants.GAP_X_CARD + Constants.DIM_X_CARD + Constants.GAP_X_CARD, Constants.GAP_Y_CARD + Constants.DIM_Y_CARD + Constants.GAP_X_CARD);

        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        setupComponents();
        setupLayout();
    }

    public void setupComponents() {
        archersAtk = new JButton("Archers Attack");
        boilingWaterAtk = new JButton("Boiling Water Attack");
        ccaAtk = new JButton("Close Combat Attack");
        coupure = new JButton("Coupure");
        rally = new JButton("Rally Troops");
        tunnelMov = new JButton("Tunnel Movement");
        supplyRaid = new JButton("Supply Raid");
        sabotage = new JButton("Sabotage");
        endTurn = new JButton("End Turn");

        archersAtk.addActionListener(new ArchersAtkListener());
        boilingWaterAtk.addActionListener(new BoilngWaterAtkListener());
        ccaAtk.addActionListener(new CcaAtkListener());
        coupure.addActionListener(new CoupureListener());
        rally.addActionListener(new RallyListener());
        tunnelMov.addActionListener(new TunnelMovBListener());
        supplyRaid.addActionListener(new SupplyRaidListener());
        sabotage.addActionListener(new SabotageListener());
        endTurn.addActionListener(new EndTurnListener());
    }

    public void setupLayout() {

        Box box = Box.createVerticalBox();
        box.add(Box.createVerticalGlue());
        box.add(archersAtk);
        box.add(Box.createVerticalGlue());
        box.add(boilingWaterAtk);
        box.add(Box.createVerticalGlue());
        box.add(ccaAtk);
        box.add(Box.createVerticalGlue());
        box.add(coupure);
        box.add(Box.createVerticalGlue());
        box.add(rally);
        box.add(Box.createVerticalGlue());
        box.add(tunnelMov);
        box.add(Box.createVerticalGlue());
        box.add(supplyRaid);
        box.add(Box.createVerticalGlue());
        box.add(sabotage);
        box.add(Box.createVerticalGlue());
        box.add(endTurn);
        box.add(Box.createVerticalGlue());
        setLayout(new BorderLayout());
        add(box, BorderLayout.CENTER);

    }

    private Boolean applyDRM() {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to use DRM?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            return true;
        }
        else
            return false;
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getState() instanceof AwaitPlayerAction);
    }

    private class ArchersAtkListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            game.archersAttack();
        }

    }

    private class BoilngWaterAtkListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            game.boilingWaterAttack();
        }

    }

    private class CcaAtkListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            game.closeCombat();
        }

    }

    private class CoupureListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            game.coupure();
        }
    }
    private class RallyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            game.rallyTroops(applyDRM());
        }
    }
    private class TunnelMovBListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            game.tunnelMovement();
        }
    }
    private class SupplyRaidListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            game.supplyRaid();
        }
    }
    private class SabotageListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            game.sabotage();
        }
    }
    private class EndTurnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            game.endOfTurn();
        }
    }

}
