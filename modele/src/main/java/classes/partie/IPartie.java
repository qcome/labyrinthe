package classes.partie;

import classes.exceptions.GameAlreadyBegunException;
import classes.exceptions.GameDoesntExistAnymoreException;
import classes.joueur.IJoueur;
import classes.plateau.IPlateau;

import java.io.Serializable;
import java.util.List;

public interface IPartie extends Serializable{

    public int getGameSize();
    public void addPlayer(IJoueur player) throws GameAlreadyBegunException, GameDoesntExistAnymoreException;
    public List<IJoueur> getPlayers();
    public void setPlayers(List<IJoueur> players);
    public int getId();
    public boolean isPrivate();
    public IJoueur getGameCreator();
    public EtatPartie getGameState();
    public void setGameState(EtatPartie gameState);


    public String getGameStateMsg();
    public boolean hasBegun();
    public boolean isEnded();
    public IPlateau getBoard();

}
