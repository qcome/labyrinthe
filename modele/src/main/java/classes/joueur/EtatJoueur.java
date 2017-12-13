package classes.joueur;

import classes.exceptions.PlayerAlreadyConnectedException;
import classes.exceptions.PlayerAlreadyInGameException;
import classes.exceptions.UnknownPlayerException;
import classes.partie.IPartie;

import java.io.Serializable;

public interface EtatJoueur extends Serializable{
    public boolean isConnected();
    public void connection() throws PlayerAlreadyConnectedException;
    public boolean isInGame();
    public void joinGame(IPartie game);
    public void addInvitation(IPartie game) throws PlayerAlreadyInGameException, UnknownPlayerException;
}
