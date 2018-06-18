package Graphical.graphicalStates;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import logicaJogo.Constants;
import logicaJogo.ObservableGame;

public class AwaitOptionSelectionPanel extends JPanel implements Observer, Constants {
    
    private ObservableGame game;
    
    private JButton archersAttackButton;
    private JButton boilingWaterAttackButton;
    private JButton ccAttackButton;
    private JButton coupureButton;
    private JButton rallyTroopsButton;
    private JButton tunnelMovButton;
    private JButton supplyRaidButton;
    private JButton sabotageButton;
    private JButton endTurnButton;
    private JButton saveGameButton;
    
    public AwaitOptionSelectionPanel(ObservableGame g){
        game = g;
        
        this.game.addObserver(this);
        
        setupComponents();
        setupLayout();
        
    }
    
    public void setupComponents(){
    archersAttackButton = new JButton("Archers Attack");
    boilingWaterAttackButton = new JButton("BoilingWater Attack");
    ccAttackButton = new JButton("Close Combat");
    coupureButton = new JButton("Coupure (Fix Wall)");
    rallyTroopsButton = new JButton("Rally Troops");
    tunnelMovButton = new JButton("Tunnel Movement");
    supplyRaidButton = new JButton("Supply Raid");
    sabotageButton = new JButton("Sabotage");
    endTurnButton = new JButton("End Turn");
    saveGameButton = new JButton("Save Game");
    
    archersAttackButton.addActionListener(new archersAttackListener());
    boilingWaterAttackButton.addActionListener(new boilingWaterAttackListener());
    ccAttackButton.addActionListener(new ccAttackListener());
    coupureButton.addActionListener(new coupureListener());
    rallyTroopsButton.addActionListener(new rallyTroopsListener());
    tunnelMovButton.addActionListener(new tunnelMovListener());
    supplyRaidButton.addActionListener(new supplyRaidListener());
    sabotageButton.addActionListener(new sabotageListener());
    endTurnButton.addActionListener(new endTurnListener());
    saveGameButton.addActionListener(new saveGameListener());
        
    }
    public void setupLayout(){
        
        /*layout layún laydos laytres*/
        
    }

    @Override
    public void update(Observable o, Object arg) {
        
    }

    private static class archersAttackListener implements ActionListener {

        public archersAttackListener() {
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        
        }
    }

    private static class boilingWaterAttackListener implements ActionListener {

        public boilingWaterAttackListener() {
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        
        }
        
    }

    private static class ccAttackListener implements ActionListener {

        public ccAttackListener() {
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        
        }
        
    }

    private static class coupureListener implements ActionListener {

        public coupureListener() {
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        
        }
        
    }

    private static class rallyTroopsListener implements ActionListener {

        public rallyTroopsListener() {
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        
        }
        
    }

    private static class tunnelMovListener implements ActionListener {

        public tunnelMovListener() {
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        
        }
        
    }

    private static class supplyRaidListener implements ActionListener {

        public supplyRaidListener() {
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        
        }
        
    }

    private static class sabotageListener implements ActionListener {

        public sabotageListener() {
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        
        }
        
    }

    private static class endTurnListener implements ActionListener {

        public endTurnListener() {
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        
        }
        
    }

    private static class saveGameListener implements ActionListener {

        public saveGameListener() {
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        
        }
        
    }
    
}
