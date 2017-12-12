package classes.partie;

import classes.exceptions.GameAlreadyBegunException;
import classes.joueur.IJoueur;

public class EtatPartieEnCours implements EtatPartie{
    IPartie game;
    public EtatPartieEnCours(IPartie game) {
        this.game = game;
    }

    public void addPlayer(IJoueur player) throws GameAlreadyBegunException {
        throw new GameAlreadyBegunException();
    }

    public boolean hasBegun() { return true; }
}
