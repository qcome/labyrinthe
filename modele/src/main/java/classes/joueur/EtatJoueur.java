package classes.joueur;

import classes.exceptions.PlayerAlreadyConnectedException;
import classes.exceptions.PlayerAlreadyInGameException;
import classes.partie.IPartie;

public interface EtatJoueur {
    public boolean isConnected();
    public void connection() throws PlayerAlreadyConnectedException;
    public boolean isInGame();
    public void joinGame(IPartie game) throws PlayerAlreadyInGameException;
}
