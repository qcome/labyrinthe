package classes.gestionnaire;

import classes.exceptions.*;
import classes.joueur.IJoueur;
import classes.partie.IPartie;

import java.io.Serializable;
import java.util.Map;

public interface IGestionnaire extends Serializable{
    public int registration(String login, String password, String passwordConfirmation) throws LoginAlreadyTakenException, LoginTooShortException, PasswordConfirmationException, PasswordTooShortException;
    public int connection(String login, String password) throws UnknownPlayerException, PlayerAlreadyConnectedException;

    public int createGame(int idPlayer, boolean isPrivate, int gameSize) throws IncorrectNumberPlayerException;
    public void sendInvitation(int idGame, int idInvitedPlayer) throws UnknownPlayerException, PlayerAlreadyInGameException;
    public void acceptInvitation(int idGame, int idPlayer) throws GameAlreadyBegunException, GameDoesntExistAnymoreException;

    public IPartie getGameById(int id);
    public IJoueur getPlayerById(int id);
    public Map<Integer, IJoueur> getMapPlayers();
    public Map<Integer, IPartie> getMapGames();

}
