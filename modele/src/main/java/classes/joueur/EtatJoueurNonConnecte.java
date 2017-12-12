package classes.joueur;

import classes.exceptions.PlayerAlreadyInGameException;
import classes.exceptions.UnknownPlayerException;
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

    public void joinGame(IPartie game)  {}

    public void addInvitation(IPartie game) throws UnknownPlayerException {
        throw new UnknownPlayerException();
    }
}
