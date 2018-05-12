package iu.Texto;
import java.util.*;
import logicaJogo.Game;
import logicaJogo.cartas.*;
import logicaJogo.estados.*;


public class Interface {
    
    protected static Game g;
    Scanner sc = new Scanner(System.in);
    
    
    
    public Interface(){
        menuInicial();
    }
    
    public void menuInicial(){
    int val;
        
        System.out.println("--------------------------------------------");
        System.out.println("-------------Nine Card Siege----------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("----------1-Let's Play----------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        
        
        val = sc.nextInt();
        
        do{
        
        System.out.println("------------------Day--" + g.getDay() + "--------------------");
        System.out.println("--------------------------------------------");
        System.out.println("----Status:----------------Enemy:-----------");
        System.out.println("--------------------------------------------");
        System.out.println("----WallStrength----" + g.getStatus().getWallStrength() + "------Ladders---" + g.getEnemy().getLadders() + "------");
        System.out.println("----Morale----------" + g.getStatus().getMorale() + "------Ram-------" + g.getEnemy().getRams() + "------");
        System.out.println("----Supplies--------" + g.getStatus().getSupplies() + "------Tower-----" + g.getEnemy().getTower() + "------");
        System.out.println("---------------------------Trebuchet-" + g.getEnemy().getTrebuchets() + "------");
        System.out.println("----Tunnel----------" + g.getStatus().getTunnel() + "-----------------------");
        System.out.println("----CarriedSupplies-" + g.getStatus().getExtraSupplies() + "-----------------------");
        System.out.println("--------------------------------------------");
        System.out.println("----AP-" + g.getActionPoints() + "--------------------ID-Carta-"/* + ID DA CARTA getID()*/ + "-----");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        val = sc.nextInt();
        
        
        
        }while(!g.getOver());
        
        
    }
    
    public static void main(String[] args) {
         
        Interface i = new Interface();
        
        g = new Game();
        
    }
    
}
