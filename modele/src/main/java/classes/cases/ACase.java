package classes.cases;

import classes.modele.Coordonnees;
import classes.modele.Direction;
import classes.plateau.IPlateau;
import classes.tresor.TypeTresor;

public abstract class ACase implements ICase{
    private boolean isMovible;
    private TypeCase typeCase;
    private Coordonnees coord;
    private Direction direction;



    private IPlateau board;

    public ACase(TypeCase typeCase, Direction direction, Coordonnees coord, IPlateau board) {
        this.typeCase = typeCase;
        this.coord = coord;
        this.direction = direction;
        this.board = board;
        this.isMovible = this.coord.getX() % 2 == 1 && this.coord.getY() % 2 == 1;
    }

    public boolean isMovible() {
        return this.isMovible;
    }

    public IPlateau getBoard() { return board; }

    @Override
    public String toString() {
        return "ACase{" +
                "isMovible=" + isMovible +
                ", typeCase=" + typeCase +
                ", coord=" + coord +
                ", direction=" + direction +
                '}';
    }
}
