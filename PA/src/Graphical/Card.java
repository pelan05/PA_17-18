package Graphical;

import logicaJogo.Constants;
import logicaJogo.ObservableGame;
import logicaJogo.estados.AwaitTopCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

public class Card extends JPanel implements Observer {

    private ObservableGame game;

    public static final int STATUS_CARD = 0;
    public static final int ENEMIES_CARD = 1;
    public static final int EVENT_CARD = 2;

    private final int type;

    private boolean front = true;


    private BufferedImage img;

    public Card(ObservableGame game, int type) {
        this.game = game;
        this.type = type;

        if (type == EVENT_CARD)
            front = false;

        setImg();

        Dimension d = new Dimension(Constants.GAP_X_CARD + img.getWidth() + Constants.GAP_X_CARD, Constants.GAP_Y_CARD + img.getHeight()  + Constants.GAP_X_CARD);

        setPreferredSize(d);
        setMaximumSize(d);
        setMinimumSize(d);

        addMouseListener(new EventListener());
    }

    public void setBack() {
        front = false;
    }

    public void setImg() {
        switch (type) {
            case EVENT_CARD:
                if (!front) {
                    img = GamePanel.getEventCardBackImg();
                } else {
                    int cardNumber = game.getGame().getCurrentEvent().getID();
                    img = GamePanel.getEventCardFrontImg(cardNumber);

                }   break;

            case STATUS_CARD:
                img = GamePanel.getStatusCardImg();
                break;
            case ENEMIES_CARD:
                img = GamePanel.getEnemiesCardImg();
                break;
            default:
                break;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (type == EVENT_CARD && game.getState() instanceof AwaitTopCard)
            setBack();

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (img != null)
            g.drawImage(img, Constants.GAP_X_CARD, Constants.GAP_Y_CARD, null);
    }

    private class EventListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent me) {
            if (game.getState() instanceof AwaitTopCard) {

                game.draw();

                front = true;
                setImg();
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
    }
}