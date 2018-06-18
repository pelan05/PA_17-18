package logicaJogo;

import java.io.Serializable;



public class DiceRoll  implements Serializable{

public int getRoll(){

    return ( (int) Math.ceil( Math.random() * 6 ) );

}
    
public int getRollDRM( int drm ){

    return ( ( (int) Math.ceil( Math.random() * 6 ) ) + drm );

}


}
