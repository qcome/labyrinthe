package classes.modele;

import java.io.Serializable;


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
