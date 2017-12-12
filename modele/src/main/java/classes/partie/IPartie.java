package classes.partie;

import classes.joueur.IJoueur;

import java.io.Serializable;
import java.util.List;

public interface IPartie extends Serializable{

    public int getGameSize();
    public void addPlayer(IJoueur player);
    public List<IJoueur> getPlayers();
    public void setPlayers(List<IJoueur> players);
    public int getId();
    public boolean isPrivate();
    public IJoueur getGameCreator();

}
