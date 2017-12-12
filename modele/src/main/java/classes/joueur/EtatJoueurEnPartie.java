package classes.joueur;

import classes.exceptions.PlayerAlreadyConnectedException;
import classes.exceptions.PlayerAlreadyInGameException;
import classes.partie.IPartie;


public class EtatJoueurEnPartie implements EtatJoueur{
    private IJoueur player;

    public EtatJoueurEnPartie(IJoueur player) {
        this.player = player;
    }

    public boolean isConnected() {
        return true;
    }

    public void connection() throws PlayerAlreadyConnectedException {
        throw new PlayerAlreadyConnectedException();
    }

    public boolean isInGame() {
        return true;
    }

    public void joinGame(IPartie game) {

    }

    public void addInvitation(IPartie game) throws PlayerAlreadyInGameException {
        throw new PlayerAlreadyInGameException();
    }


}
