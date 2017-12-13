package classes.cases;

import classes.modele.Coordonnees;
import classes.tresor.TypeTresor;

public abstract class ACase implements ICase{
    private boolean isMovible;
    private TypeCase typeCase;
    private Coordonnees coord;

    public ACase(TypeCase typeCase, Coordonnees coord) {
        this.typeCase = typeCase;
        this.coord = coord;
        this.isMovible = this.coord.getX() % 2 == 1 && this.coord.getY() % 2 == 1;
    }

    public boolean isMovible() {
        return this.isMovible;
    }

    @Override
    public String toString() {
        return "ACase{" +
                "isMovible=" + isMovible +
                ", typeCase=" + typeCase +
                ", coord=" + coord +
                '}';
    }
    
}
