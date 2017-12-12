package classes.partie;

import classes.exceptions.GameAlreadyBegunException;
import classes.exceptions.GameDoesntExistAnymoreException;
import classes.joueur.IJoueur;

import java.io.Serializable;

public interface EtatPartie extends Serializable {
    public void addPlayer(IJoueur player) throws GameAlreadyBegunException, GameDoesntExistAnymoreException;
    public boolean hasBegun();
}
