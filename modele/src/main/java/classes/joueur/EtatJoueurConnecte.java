package classes.joueur;

import classes.exceptions.PlayerAlreadyConnectedException;
import classes.partie.IPartie;

public class EtatJoueurConnecte implements EtatJoueur {

    private IJoueur player;

    public EtatJoueurConnecte(IJoueur player) {
        this.player = player;
    }

    public boolean isConnected() {
        return true;
    }

    public void connection() throws PlayerAlreadyConnectedException {
        throw new PlayerAlreadyConnectedException();
    }

    public boolean isInGame() {
        return false;
    }

    public void joinGame(IPartie game) {
        this.player.setPlayerState(FabriqueEtatJoueur.getInstance().getEtatJoueurEnPartie(this.player));
    }
}
