package classes.partie;

import classes.exceptions.GameAlreadyBegunException;
import classes.exceptions.GameDoesntExistAnymoreException;
import classes.joueur.IJoueur;
import classes.joueur.Joueur;

import java.util.ArrayList;
import java.util.List;

public class Partie implements IPartie{
    private List<IJoueur> players;

    private EtatPartie gameState;

    private final int gameSize;
    private final boolean isPrivate;
    private final int id;

    private static int idGames = 1;

    public Partie(IJoueur player, boolean isPrivate, int nbPlayers) {
        this.isPrivate = isPrivate;
        this.players = new ArrayList<IJoueur>();
        this.players.add(player);
        this.gameState = FabriqueEtatPartie.getInstance().getEtatPartieLobby(this);
        this.gameSize = nbPlayers;
        this.id = idGames++;
    }

    public void addPlayer(IJoueur player) throws GameAlreadyBegunException, GameDoesntExistAnymoreException { gameState.addPlayer(player); }

    public int getGameSize() { return gameSize; }

    public List<IJoueur> getPlayers() { return players; }

    public void setPlayers(List<IJoueur> players) { this.players = players; }

    public int getId() { return id; }

    public boolean isPrivate() { return isPrivate; }

    public IJoueur getGameCreator(){ return this.players.get(0);}

    public EtatPartie getGameState() { return gameState; }

    public void setGameState(EtatPartie gameState) { this.gameState = gameState; }


    @Override
    public String toString() {
        return "Partie{" +
                "players=" + players.toString() +
                ", gameState=" + gameState +
                ", gameSize=" + gameSize +
                ", isPrivate=" + isPrivate +
                ", id=" + id +
                '}';
    }
}
