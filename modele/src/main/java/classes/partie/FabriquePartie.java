package classes.partie;

import classes.joueur.IJoueur;

public class FabriquePartie {

    private static FabriquePartie myPlayer = null;

    private FabriquePartie(){ }

    public static FabriquePartie getInstance() {
        if (myPlayer == null) {
            myPlayer = new FabriquePartie();
        }
        return myPlayer;
    }

    public IPartie createGame(IJoueur joueur, boolean isPrivate, int nbPlayers) {
        return new Partie(joueur, isPrivate, nbPlayers);
    }
}
