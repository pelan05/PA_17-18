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
    int i;
        
        System.out.println("hey yo");
        i = sc.nextInt();
    
    }
    
    public static void main(String[] args) {
         
        Interface i = new Interface();
        
        g = new Game();
        
    }
    
}
