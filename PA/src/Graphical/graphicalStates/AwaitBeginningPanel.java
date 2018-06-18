package Graphical.graphicalStates;

import Graphical.GraphicalPanel;
import logicaJogo.Constants;
import logicaJogo.ObservableGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import logicaJogo.estados.AwaitBeggining;

public class AwaitBeginningPanel extends JPanel implements Observer, Constants {

    private JLabel areaLabel;
    private JComboBox areaComboBox;

    private JButton startGame;

    private ObservableGame game;

    public AwaitBeginningPanel(ObservableGame g){
        game = g;
        this.game.addObserver(this);
        setupComponents();
        setupLayout();

        update(game, this);
    }

    public void setupComponents(){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension(screenSize.width, screenSize.height));

        startGame = new JButton("Start Game");

        areaLabel.setFont(new Font("Arial", Font.BOLD, 15));
        areaLabel.setForeground(Color.WHITE);
        startGame.setFont(new Font("Arial", Font.BOLD, 15));

        startGame.addActionListener(new StartListener());
    }

    public void setupLayout(){
        setLayout(new GridBagLayout());

        setForeground(Color.WHITE);

        setBackground(new Color(0,0,0,1));
        setPreferredSize(new Dimension(690, 1000));

        Box startBox = Box.createVerticalBox();
        startBox.add(areaLabel);
        startBox.add(areaComboBox);
        startBox.add(startGame);

        add(startBox, new GridBagConstraints());
    }

    @Override
    public void update(Observable t, Object o) {

        if(!game.toString().equals(""))
            JOptionPane.showMessageDialog(null, game.toString(), "InfoBox: " + "Nine Card Siege", JOptionPane.INFORMATION_MESSAGE);

        setVisible(game.getState() instanceof AwaitBeggining);
    }

    class StartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e){
            game.start();

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(GraphicalPanel.getIntroImage(), 0, 50, 645, 900, this);
    }
}