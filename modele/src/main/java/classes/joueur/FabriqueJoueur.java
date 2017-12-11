package classes.joueur;

public class FabriqueJoueur {

    private static FabriqueJoueur myPlayer = null;

    private FabriqueJoueur(){ }

    public static FabriqueJoueur getInstance() {
        if (myPlayer == null) {
            myPlayer = new FabriqueJoueur();
        }
        return myPlayer;
    }

    public IJoueur createPlayer(String login, String password) {
        return new Joueur(login, password);
    }
}
