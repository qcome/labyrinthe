package classes.cases;

import classes.modele.Coordonnees;
import classes.tresor.TypeTresor;

public class CaseTresor extends ACase{
    private TypeTresor typeTresor;

    public CaseTresor(TypeCase typeCase, TypeTresor typeTresor, Coordonnees coord) {
        super(typeCase, coord);
        this.typeTresor = typeTresor;

    }


    @Override
    public String toString() {
        return super.toString() +
                ", typeTresor=" + typeTresor +
                '}';
    }
}
