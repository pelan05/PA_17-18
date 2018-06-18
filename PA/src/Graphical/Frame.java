package Graphical;

import logicaJogo.Constants;
import logicaJogo.ObservableGame;
import logicaJogo.estados.AwaitBeggining;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

public class Frame extends JFrame implements Observer {

    private ObservableGame game;
    private GamePanel gamePanel;
    private Start startPanel;
    private JMenuBar menuBar;

    private Container cp;


    public Frame(ObservableGame game) {
        this(
                game, Constants.START_X_FRAME, Constants.START_Y_FRAME, Constants.DIM_X_FRAME, Constants.DIM_Y_FRAME
        );
    }

    public Frame(ObservableGame game, int x, int y) {
        this(
                game,
                x, y,
                Constants.DIM_X_FRAME, Constants.DIM_Y_FRAME
        );
    }

    public Frame(ObservableGame game, int x, int y, int width, int height) {
        super("9 Card Siege");

        this.game = game;
        this.game.addObserver(this);
        startPanel = new Start(game);
        gamePanel = new GamePanel(game);
        menuBar = addMenuBar();
        setLocation(x, y);

        addComponents();

        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        validate();
    }

    public JMenuBar addMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        addGameMenu(menuBar);
        addHelpMenu(menuBar);
        return menuBar;
    }
    private void addGameMenu(JMenuBar menuBar) {
        JMenu gameMenu = new JMenu("Game");

        JMenuItem newGame = new JMenuItem("New Game");
        newGame.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        JMenuItem loadGame = new JMenuItem("Load");
        loadGame.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_L, ActionEvent.CTRL_MASK));

        JMenuItem saveGame = new JMenuItem("Save");
        saveGame.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        JMenuItem exitGame = new JMenuItem("Exit");
        exitGame.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        gameMenu.add(newGame);
        gameMenu.add(loadGame);
        gameMenu.add(saveGame);
        gameMenu.addSeparator();

        gameMenu.add(exitGame);

        menuBar.add(gameMenu);

        newGame.addActionListener(new Frame.NewGameBarListener());
        loadGame.addActionListener(new Frame.LoadGameBarListener());
        saveGame.addActionListener(new Frame.SaveGameBarListener());
        exitGame.addActionListener(new Frame.ExitGameBarListener());

    }

    private void addHelpMenu(JMenuBar menuBar) {
        JMenu helpMenu = new JMenu("Help");

        JMenuItem manual = new JMenuItem("Manual");
        manual.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK)
        );

        JMenuItem about = new JMenuItem("About");
        about.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK)
        );

        helpMenu.add(manual);
        helpMenu.add(about);

        menuBar.add(helpMenu);

        manual.addActionListener(new Frame.ManualHelpBarListener());
        manual.addActionListener(new Frame.AboutHelpBarListener());
    }

    //Listeners
    class NewGameBarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.start();
        }

    }
    class LoadGameBarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.loadGame();
        }
    }
    class SaveGameBarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.saveGame();
        }
    }
    class ExitGameBarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    class ManualHelpBarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
    class AboutHelpBarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    private void addComponents() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(new BorderLayout( ));

        setContentPane(new JLabel(new ImageIcon(GamePanel.getGameBackground().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH))));
        cp = getContentPane();

        cp.setLayout(new FlowLayout());
        setJMenuBar(menuBar);
        cp.add(startPanel);
    }

    @Override
    public void update(Observable t, Object o) {
        System.out.println("UPDATING. STATE => " + game.getState());
        if (!(game.getState() instanceof AwaitBeggining) ) {
            cp.remove(startPanel);
            cp.add(gamePanel, BorderLayout.CENTER);
        }

        gamePanel.update(game, null);

        revalidate();
        repaint();
    }
}
