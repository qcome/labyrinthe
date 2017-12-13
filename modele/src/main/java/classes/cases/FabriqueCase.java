package classes.cases;

import classes.modele.Coordonnees;
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

    public ICase getCaseTresor(TypeCase typeCase, TypeTresor typeTresor, Coordonnees coord) {
        return new CaseTresor(typeCase, typeTresor, coord);
    }

    public ICase getCaseSimple(TypeCase typeCase, Coordonnees coord){
        return new CaseSimple(typeCase, coord);
    }

}
