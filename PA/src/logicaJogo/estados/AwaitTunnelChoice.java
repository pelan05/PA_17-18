package logicaJogo.estados;

import logicaJogo.Game;

public class AwaitTunnelChoice extends StateAdapter {

    public AwaitTunnelChoice(Game game) {
        super(game);
    }
    
    @Override   //entra e paga
    public Estado enterTunnel() {
        getGame().enterTunnel();
        
        return new AwaitPlayerAction(getGame());
    }
    
    @Override   //volta pro castelo
    public Estado exitTunnel() {
        getGame().exitTunnel();
        
        return new AwaitPlayerAction(getGame());
    }
    
    @Override   //fim do tunel e paga
    public Estado paidTunnelMovement() {
        getGame().paidTunnel();
        
        return new AwaitPlayerAction(getGame());
    }
    
    @Override   //volta pra tras e traz os extra supplies
    public Estado tunnelMovement() {
        getGame().normalTunnel();
        
        return new AwaitPlayerAction(getGame());
    }
    

}
