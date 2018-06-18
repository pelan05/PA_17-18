package Graphical;

import iu.Texto.Interface;
import logicaJogo.ObservableGame;
import logicaJogo.estados.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.*;

import static logicaJogo.Constants.*;


public class GamePanel extends JPanel implements Observer {

    static private HashMap<String, BufferedImage> imgs = null;

    public static BufferedImage getStatusCardImg() {
        return imgs.get("StatusCard");
    }

    public static BufferedImage getEnemiesCardImg() {
        return imgs.get("EnemiesCard");
    }
    public static BufferedImage getEventCardBackImg() {
        return imgs.get("EventCardBack");
    }
    public static BufferedImage getEventCardFrontImg(int cardNumber) {
        return imgs.get("Card" + cardNumber);
    }

    public static BufferedImage getGameBackground() {
        return imgs.get("Background");
    }

    static {
        try {
            imgs = new HashMap<>();
            imgs.put("StatusCard", ImageIO.read(Resources.getResourceFile(IMG_STATUS)));
            imgs.put("Background", ImageIO.read(Resources.getResourceFile(IMG_BACKGROUND)));
            imgs.put("EnemiesCard", ImageIO.read(Resources.getResourceFile(IMG_ENEMY)));
            imgs.put("EventCardBack", ImageIO.read(Resources.getResourceFile(IMG_BACK)));
            imgs.put("Card1", ImageIO.read(Resources.getResourceFile(IMG1)));
            imgs.put("Card2", ImageIO.read(Resources.getResourceFile(IMG2)));
            imgs.put("Card3", ImageIO.read(Resources.getResourceFile(IMG3)));
            imgs.put("Card4", ImageIO.read(Resources.getResourceFile(IMG4)));
            imgs.put("Card5", ImageIO.read(Resources.getResourceFile(IMG5)));
            imgs.put("Card6", ImageIO.read(Resources.getResourceFile(IMG6)));
            imgs.put("Card7", ImageIO.read(Resources.getResourceFile(IMG7)));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private ObservableGame game;
    private Card statusPanel;
    private Card enemiesPanel;
    private Card eventPanel;
    private AwaitPlayerActionPanel awaitPlayerActionPanel;
    private GameOverPanel gameOverPanel;
    private RowSelectPanel rowSelectPanel;
    private TunnelMovePanel tunnelMovPanel;
    private JPanel choicePanel;
    private JLabel choiceLabel;
    private JLabel day;
    private JLabel ap;
    private JLabel status;
    private JLabel enemy;


    public GamePanel(ObservableGame game) {
        this.game = game;

        setupComponents();
        setupLayout();

        update(game, null);
    }

    private void setupComponents() {
        statusPanel = new Card(game, Card.STATUS_CARD);
        enemiesPanel = new Card(game, Card.ENEMIES_CARD);
        eventPanel = new Card(game, Card.EVENT_CARD);

        awaitPlayerActionPanel = new AwaitPlayerActionPanel(game);
        rowSelectPanel = new RowSelectPanel(game);
        tunnelMovPanel = new TunnelMovePanel(game);
        gameOverPanel = new GameOverPanel(game);

        choicePanel = new JPanel();
        choiceLabel = new JLabel();
        day = new JLabel("Day: " + game.getGame().getDay());
        ap = new JLabel("Action Points: " + game.getGame().getActionPoints());
        status = new JLabel();
        enemy = new JLabel();
    }

    private void setupLayout() {

        Box leftTopBox = Box.createVerticalBox();
        leftTopBox.add(Box.createVerticalGlue());
        leftTopBox.add(new JLabel("Status"));
        leftTopBox.add(Box.createVerticalGlue());
        leftTopBox.add(statusPanel);
        leftTopBox.add(Box.createVerticalGlue());

        Box rightTopBox = Box.createVerticalBox();
        rightTopBox.add(Box.createVerticalGlue());
        rightTopBox.add(new JLabel("Enemy"));
        rightTopBox.add(Box.createVerticalGlue());
        rightTopBox.add(enemiesPanel);
        rightTopBox.add(Box.createVerticalGlue());

        Box topBox = Box.createHorizontalBox();
        topBox.add(Box.createHorizontalGlue());
        topBox.add(leftTopBox);
        topBox.add(Box.createHorizontalGlue());
        topBox.add(rightTopBox);
        topBox.add(Box.createHorizontalGlue());


        Box leftBotBox = Box.createVerticalBox();
        leftBotBox.add(Box.createVerticalGlue());
        leftBotBox.add(new JLabel("Event"));
        leftBotBox.add(Box.createVerticalGlue());
        leftBotBox.add(eventPanel);
        leftBotBox.add(Box.createVerticalGlue());

        Box rightBotBox = Box.createVerticalBox();
        rightBotBox.add(Box.createVerticalGlue());
        rightBotBox.add(choiceLabel);
        rightBotBox.add(Box.createVerticalGlue());
        rightBotBox.add(choicePanel);
        rightBotBox.add(Box.createVerticalGlue());

        Box botBox = Box.createHorizontalBox();
        botBox.add(Box.createHorizontalGlue());
        botBox.add(leftBotBox);
        botBox.add(Box.createHorizontalGlue());
        botBox.add(rightBotBox);
        botBox.add(Box.createHorizontalGlue());

        Box center = Box.createVerticalBox();
        center.add(Box.createVerticalGlue());
        center.add(topBox);
        center.add(Box.createVerticalGlue());
        center.add(botBox);
        center.add(day);
        center.add(ap);
        center.add(status);
        center.add(enemy);
        center.add(Box.createVerticalGlue());

        setLayout(new BorderLayout());
        add(leftTopBox, BorderLayout.WEST);
        add(rightTopBox, BorderLayout.EAST);
        add(center, BorderLayout.CENTER);
    }

    public void swapChoicePanel(JPanel newPanel) {
        choicePanel.removeAll();
        choicePanel.add(newPanel);
        choicePanel.setVisible(true);
    }

    @Override
    public void update(Observable o, Object o1) {
        if (game.getState() instanceof AwaitTopCard)
            eventPanel.setBack();

        if (game.getState() instanceof AwaitPlayerAction) {
            swapChoicePanel(awaitPlayerActionPanel);
            choiceLabel.setText("Select Action");


        } else if (game.getState() instanceof AwaitTrackDirection) {
            swapChoicePanel(rowSelectPanel);
            choiceLabel.setText("Select Row");

        } else if (game.getState() instanceof AwaitTunnelChoice) {
            swapChoicePanel(tunnelMovPanel);
            choiceLabel.setText("Select Tunnel Movement");

        if(game.getState() instanceof GameOver){
            swapChoicePanel(gameOverPanel);
        }
        } else {
            choicePanel.setVisible(false);
            choiceLabel.removeAll();
        }
        day.setText("Day: " + Integer.toString(game.getGame().getDay()));
        ap.setText("Action Points: " + Integer.toString(game.getGame().getActionPoints()));
        status.setText(game.getGame().getStatus().toString());
        enemy.setText(game.getGame().getEnemy().toString());

        revalidate();
        repaint();
    }
}
