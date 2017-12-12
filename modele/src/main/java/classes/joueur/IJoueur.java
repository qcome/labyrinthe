package classes.joueur;

import classes.Couleur;
import classes.exceptions.PlayerAlreadyConnectedException;
import classes.exceptions.PlayerAlreadyInGameException;
import classes.exceptions.UnknownPlayerException;
import classes.partie.IPartie;

import java.io.Serializable;
import java.util.Map;

public interface IJoueur extends Serializable{
    public String getLogin();
    public void setLogin(String login);
    public String getPassword();
    public void setPassword(String password);
    public Couleur getColor();
    public void setColor(Couleur color);
    public int getId();

    public EtatJoueur getPlayerState();
    public void setPlayerState(EtatJoueur playerState);

    public void connection() throws PlayerAlreadyConnectedException;
    public void joinGame(IPartie game);
    public void sendInvitation(IJoueur invitedPlayer, IPartie game) throws PlayerAlreadyInGameException, UnknownPlayerException;
    public void addInvitation(IPartie game);

    public Map<Integer, IPartie> getInvitations();
}
