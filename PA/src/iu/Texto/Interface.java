package iu.Texto;
import java.util.*;
import logicaJogo.Game;
import logicaJogo.cartas.*;
import logicaJogo.estados.*;


public class Interface {
    
    protected static Game g = new Game();;
    Scanner sc = new Scanner(System.in);
    
    
    
    public Interface(){
        menuInicial();
    }
    
    public void menuInicial(){
    int val = 0;
        
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
       
        
        
        
    }
    
    
    public void mainScreen(){
    int val = 0;
        
        
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
        
        }while(/*!g.getOver()*/true);
        
        
        
    
    }
    
    public void choiceScreen(){
    int val = 0;
    
    do{
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("---------" /*+ g.getEvent().getAvailable()*/ + "1.ArchersAttack-------------------");/**///esolher track
        System.out.println("---------" /*+ g.getEvent().getAvailable()*/ + "2.BoilingWaterAttack--------------");/**/
        System.out.println("---------" /*+ g.getEvent().getAvailable()*/ + "3.CloseCombatAttack---------------");
        System.out.println("---------" /*+ g.getEvent().getAvailable()*/ + "4.Coupure-------------------------");
        System.out.println("---------" /*+ g.getEvent().getAvailable()*/ + "5.RallyTroops---------------------");/**///gastar ou nao gastar? eis a questão
        System.out.println("---------" /*+ g.getEvent().getAvailable()*/ + "6.TunnelMovement------------------");/**/
        System.out.println("---------" /*+ g.getEvent().getAvailable()*/ + "7.SupplyRaid----------------------");
        System.out.println("---------" /*+ g.getEvent().getAvailable()*/ + "8.Sabotage------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        
        
        val = sc.nextInt();
        
        }while(val < 1 || val > 8);
    
        //choice method
        switch (val){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
        
        }
         
    }
    
    public void trackScreen(){
        int val = 0;
        do{
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("---------Choose-the-track:------------------");
        System.out.println("--------------------------------------------");
        System.out.println("---------1.Ladders--------------------------");
        System.out.println("---------2.Ram------------------------------");
        System.out.println("---------3.Tower----------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        
        
        val = sc.nextInt();
    
        
        }while(val < 1 || val > 3);
        
        
        //choice method
        switch (val){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        
    }
    
    public void paymentScreen(){
        int val = 0;
        do{
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("------Do you wish to pay for the bonus?-----");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("----------1.Yes OFC-------------------------");
        System.out.println("----------2.No Señor------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        
        
        val = sc.nextInt();
        


        }while(val < 1 || val > 2);

        //choice method
        switch (val){
            case 1:
                break;
            case 2:
                break;
        }
        
    }
    
    
    public static void main(String[] args) {
         
        Interface i = new Interface();
        
        
    }
    
}
