package classes.partie;

import classes.exceptions.GameAlreadyBegunException;
import classes.exceptions.GameDoesntExistAnymoreException;
import classes.joueur.IJoueur;

public class EtatPartieTerminee implements EtatPartie{
    IPartie game;
    public EtatPartieTerminee(IPartie game) {
        this.game = game;
    }

    public void addPlayer(IJoueur player) throws GameAlreadyBegunException, GameDoesntExistAnymoreException {
        throw new GameDoesntExistAnymoreException();
    }

    public boolean hasBegun() {
        return false;
    }
}
