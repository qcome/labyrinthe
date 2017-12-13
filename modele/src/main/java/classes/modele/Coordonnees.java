package classes.modele;

import java.io.Serializable;

/**
 * Created by o2131661 on 10/04/17.
 */
public class Coordonnees implements Serializable {

    int x;
    int y;

    public Coordonnees(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
