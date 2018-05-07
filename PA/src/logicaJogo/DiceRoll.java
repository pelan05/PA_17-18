package logicaJogo;



public class DiceRoll {

public int getRoll(){

    return ( (int) Math.ceil( Math.random() * 6 ) );

}
    
public int getRollDRM( int drm ){

    return ( ( (int) Math.ceil( Math.random() * 6 ) ) + drm );

}


}
