package classes.joueur;

import classes.exceptions.PlayerAlreadyInGameException;
import classes.partie.IPartie;

public class EtatJoueurNonConnecte implements EtatJoueur{

    private IJoueur player;

    public EtatJoueurNonConnecte(IJoueur player) {
        this.player = player;
    }

    public void connection() {
        this.player.setPlayerState(FabriqueEtatJoueur.getInstance().getEtatJoueurConnecte(player));
    }

    public boolean isConnected(){ return false;}

    public boolean isInGame() { return false; }

    public void joinGame(IPartie game) throws PlayerAlreadyInGameException {

    }
}
