package classes.cases;

import classes.modele.Coordonnees;
import classes.modele.Direction;
import classes.plateau.IPlateau;
import classes.tresor.TypeTresor;

public class CaseTresor extends ACase{
    private TypeTresor typeTresor;

    public CaseTresor(TypeCase typeCase, Direction direction, TypeTresor typeTresor, Coordonnees coord, IPlateau board) {
        super(typeCase, direction, coord, board);
        this.typeTresor = typeTresor;

    }


    @Override
    public String toString() {
        return super.toString() +
                ", typeTresor=" + typeTresor +
                '}';
    }
}
