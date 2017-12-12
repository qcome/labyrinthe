package classes.partie;

import classes.joueur.IJoueur;

import java.io.Serializable;

public interface EtatPartie extends Serializable {
    public void addPlayer(IJoueur player);
}
