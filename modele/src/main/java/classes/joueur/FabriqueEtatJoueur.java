package classes.joueur;

public class FabriqueEtatJoueur {
    private static FabriqueEtatJoueur myGameState = null;

    private FabriqueEtatJoueur(){
    }

    public static FabriqueEtatJoueur getInstance() {
        if (myGameState == null) {
            myGameState = new FabriqueEtatJoueur();
        }
        return myGameState;
    }

    public EtatJoueur getEtatJoueurNonConnecte(IJoueur player) {
        return new EtatJoueurNonConnecte(player);
    }
    public EtatJoueur getEtatJoueurConnecte(IJoueur player) { return new EtatJoueurConnecte(player); }
    public EtatJoueur getEtatJoueurEnPartie(IJoueur player) { return new EtatJoueurEnPartie(player); }
}
