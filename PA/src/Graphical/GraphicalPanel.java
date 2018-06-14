package Graphical;

import logicaJogo.Constants;
import logicaJogo.ObservableGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class GraphicalPanel  extends JPanel implements Observer, Constants {

    static private BufferedImage introImage = null;
    static private BufferedImage gameBackground = null;
    static private BufferedImage backCard = null;
    static private BufferedImage statsCard = null;
    static private BufferedImage enemyCard = null;
    static private BufferedImage eventCard1 = null;
    static private BufferedImage eventCard2 = null;
    static private BufferedImage eventCard3 = null;
    static private BufferedImage eventCard4 = null;
    static private BufferedImage eventCard5 = null;
    static private BufferedImage eventCard6 = null;
    static private BufferedImage eventCard7 = null;


    static {
        try {
            introImage = ImageIO.read(Resources.getResourceFile(INTRO_IMAGE));
            gameBackground = ImageIO.read(Resources.getResourceFile(GAME_BACKGROUND));
            statsCard = ImageIO.read(Resources.getResourceFile(IMG_STATUS));
            backCard = ImageIO.read(Resources.getResourceFile(IMG_BACK));
            enemyCard = ImageIO.read(Resources.getResourceFile(IMG_ENEMY));
            eventCard1 = ImageIO.read(Resources.getResourceFile(IMG1));
            eventCard2 = ImageIO.read(Resources.getResourceFile(IMG2));
            eventCard3 = ImageIO.read(Resources.getResourceFile(IMG3));
            eventCard4 = ImageIO.read(Resources.getResourceFile(IMG4));
            eventCard5 = ImageIO.read(Resources.getResourceFile(IMG5));
            eventCard6 = ImageIO.read(Resources.getResourceFile(IMG6));
            eventCard7 = ImageIO.read(Resources.getResourceFile(IMG7));
        } catch (IOException e) {
            System.out.println("Error loading images ");
        }
    }

    ObservableGame observableGame;
    StatsPanel statsPanel;
    EnemyPanel enemyPanel;
    AwaitBeginningPanel awaitBeginningPanel;
    AwaitCardSelectionPanel awaitCardSelectionPanel;
    AwaitOptionSelectionPanel awaitOptionSelectionPanel;
    AwaitDiceRerrollPanel awaitDiceRerrollPanel;

    public GraphicalPanel(ObservableGame game){
        observableGame = game;
        this.observableGame.addObserver(this);

        setupComponents();
        setupLayout();

        update(game, null);
    }

    public static BufferedImage getIntroImage(){
        return introImage;
    }
    public static BufferedImage getGameBackground() {
        return gameBackground;
    }
    public static BufferedImage getBackCard(){ return backCard; }
    public static BufferedImage getStatsCard() {
        return statsCard;
    }
    public static BufferedImage getEnemyCard() {
        return enemyCard;
    }
    public static BufferedImage getEventCard() {
        return eventCard;
    }

    private void setupComponents(){
        setBackground(new Color(0,0,0,1));

        statsPanel = new StatsPanel(observableGame);
        enemyPanel = new EnemyPanel(observableGame);

        awaitBeginningPanel = new AwaitBeginningPanel(observableGame);
        awaitCardSelectionPanel = new AwaitCardSelectionPanel(observableGame);
        awaitOptionSelectionPanel = new AwaitOptionSelectionPanel(observableGame);

        awaitDiceRerrollPanel = new AwaitDiceRerrollPanel(observableGame);
    }
    private void setupLayout(){
        JPanel main = new JPanel();
        main.add(awaitBeginningPanel);
        main.add(awaitCardSelectionPanel);
        main.add(awaitOptionSelectionPanel);

        main.add(awaitDiceRerrollPanel);

        main.setBackground(new Color(0,0,0,1));

        JPanel statsPanel = new JPanel();
        statsPanel.add(statsPanel);
        statsPanel.setBackground(new Color(0,0,0,1));

        JPanel dungPanel = new JPanel();
        dungPanel.add(enemyPanel);
        dungPanel.setBackground(new Color(0,0,0,1));

        setLayout(new BorderLayout());
        add(main, BorderLayout.CENTER);
        add(statsPanel, BorderLayout.SOUTH);
        add(dungPanel, BorderLayout.WEST);
    }

    @Override
    public void update(Observable t, Object o) {

    }
}
