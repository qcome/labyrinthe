package classes.cases;

import classes.modele.Coordonnees;
import classes.modele.Direction;
import classes.plateau.IPlateau;
import classes.tresor.TypeTresor;

public class CaseSimple extends ACase {

    public CaseSimple(TypeCase typeCase, Direction direction, Coordonnees coord, IPlateau board) {
        super(typeCase, direction, coord, board);
    }
}
