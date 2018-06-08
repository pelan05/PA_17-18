package iu.Texto;
import java.io.*;
import java.util.*;
import logicaJogo.Game;
import logicaJogo.ObservableGame;
import logicaJogo.cartas.*;
import logicaJogo.estados.*;


public class Interface {

    private ObservableGame Obgame;
    private Scanner scanner;
    private boolean trackdirection;

    public Interface(ObservableGame Obgame) {
        this.Obgame = Obgame;
        scanner = new Scanner(System.in);
        trackdirection = false;
    }

    public void showGame() {
        System.out.println(Obgame);
    }

    public void menuInicial() {
        while (!(Obgame.getState() instanceof GameOver)) {

            if (Obgame.getInfo().size() > 0) {
                System.out.println("");

                Obgame.getInfo().forEach((info) -> {
                    System.out.println("--> " + info);
                });

                Obgame.clearInfo();
            }

            System.out.println(Obgame.toString());

            if (Obgame.getState() instanceof AwaitBeggining)
                getUserInputAwaitingStart();

            else if(Obgame.getState() instanceof AwaitTopCard)
                getUserInputAwaitingTopCard();

            else if(Obgame.getState() instanceof AwaitPlayerAction)
                getUserInputAwaitingActionChoice();

            else if (Obgame.getState() instanceof AwaitTunnelChoice)
                getUserInputTunnelChoice();

            else if (Obgame.getState() instanceof AwaitRowDirection)
                getUserInputAwaitngRowDirection();
        }
    }

    private void getUserInputAwaitingTopCard() {
        System.out.println("Press any key to draw card!");
        System.out.println(">> ");

        scanner.nextInt();

        Obgame.draw();
    }

    private void getUserInputAwaitingStart() {
        int value;

        System.out.println("1 - Start Game");

        System.out.println(">> ");

        while(!scanner.hasNextInt())
            scanner.next();

        value = scanner.nextInt();


        switch (value) {
            case 1: Obgame.start();
            default: break;
        }
    }

    private void getUserInputAwaitingActionChoice() {
        int value;

        
                
        
        System.out.println("1 - Archers Attack");
        System.out.println("2 - Boiling Water Attack");
        System.out.println("3 - Close Combat Attack");
        System.out.println("4 - Coupure");
        System.out.println("5 - Rally Troops");
        System.out.println("6 - Tunnel Movement");
        System.out.println("7 - Supply Raid");
        System.out.println("8 - Sabotage");
        System.out.println("9 - End Turn");
        System.out.println(">> ");

        while (!scanner.hasNextInt())
            scanner.next();

        value = scanner.nextInt();

       if (value == 1 || value == 2)
            if (!trackdirection) {
                Obgame.setState(new AwaitRowDirection(Obgame.getGame()));
                
                
            }

        switch (value) {
            case 1:
                Obgame.archersAttack();
                break;
            case 2:
                Obgame.boilingWaterAttack();
                break;
            case 3:
                Obgame.closeCombat();
                break;
            case 4:
                Obgame.coupure();
                break;
            case 5:
                Obgame.rallyTroops(applyDRM());
                break;
            case 6:
                Obgame.tunnelMovement();
                break;
            case 7:
                Obgame.supplyRaid();
                break;
            case 8:
                Obgame.sabotage();
                break;
            case 9:
                Obgame.endOfTurn();
                break;
            default:
                System.out.println("Escolha uma opção válida!");
                break;
        }

       trackdirection = false;
    }

    private Boolean applyDRM() {
        System.out.println("Spend 1 supply to apply +1 DRM in moralle roll?");
        System.out.println(">> ");

        while (!scanner.hasNextLine())
            scanner.next();

        String s = scanner.nextLine();
        return s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("S");
    }

    private void getUserInputAwaitngRowDirection() {
        int value;

        System.out.println("1 - Ladder");
        System.out.println("2 - Ram");
        System.out.println("3 - Tower");
        System.out.println("--> ");

        while (!scanner.hasNextInt())
            scanner.next();

        value = scanner.nextInt();

        Obgame.selectRowChoice(value);
    }

    private void getUserInputTunnelChoice() {
        int value;

        System.out.println("1 - Enter Tunnel ");
        System.out.println("2 - Exit Tunnel ");
        System.out.println("3 - Advance ");
        System.out.println("4 - Exit ");
        System.out.println("5 - FastMovement ");
        System.out.println("--> ");

        while (!scanner.hasNextInt())
            scanner.next();

        value = scanner.nextInt();

        switch(value) {
            case 1:
                Obgame.enterTunnel();
                break;
            case 2:
                Obgame.exitTunnel();
                break;
            case 3:
                Obgame.tunnelMovement();
                break;
            case 4:
                Obgame.exitTunnel();
                break;
            case 5:
                Obgame.fastMovement();
                break;
        }
    }
}