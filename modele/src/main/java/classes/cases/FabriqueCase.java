package classes.cases;

import classes.modele.Coordonnees;
import classes.modele.Direction;
import classes.plateau.IPlateau;
import classes.tresor.TypeTresor;

public class FabriqueCase {
    private static FabriqueCase myCase = null;

    private FabriqueCase(){ }

    public static FabriqueCase getInstance() {
        if (myCase == null) {
            myCase = new FabriqueCase();
        }
        return myCase;
    }

    public ICase getCaseTresor(TypeCase typeCase, Direction direction, TypeTresor typeTresor, Coordonnees coord, IPlateau board) {
        return new CaseTresor(typeCase, direction, typeTresor, coord, board);
    }

    public ICase getCaseSimple(TypeCase typeCase, Direction direction, Coordonnees coord, IPlateau board){
        return new CaseSimple(typeCase, direction, coord, board);
    }

}
