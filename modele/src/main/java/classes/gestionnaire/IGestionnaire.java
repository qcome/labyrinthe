package classes.gestionnaire;

import classes.exceptions.*;
import classes.joueur.IJoueur;
import classes.partie.IPartie;

import java.io.Serializable;
import java.util.Map;

public interface IGestionnaire extends Serializable{
    public int registration(String login, String password, String passwordConfirmation) throws LoginAlreadyTakenException, LoginTooShortException, PasswordConfirmationException, PasswordTooShortException;
    public Map<Integer, IJoueur> getMapPlayers();
    public int connection(String login, String password) throws UnknownPlayerException, PlayerAlreadyConnectedException;
    public IPartie createGame(int idPlayer, boolean isPrivate, int gameSize) throws PlayerAlreadyInGameException;
    public IJoueur getPlayerById(int id);
}
