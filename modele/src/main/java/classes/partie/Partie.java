package classes.partie;

import classes.joueur.IJoueur;
import classes.joueur.Joueur;

import java.util.ArrayList;
import java.util.List;

public class Partie implements IPartie{
    private List<IJoueur> players;
    private EtatPartie etatPartie;

    private final int gameSize;
    private final boolean isPrivate;
    private final int id;

    private static int idGames = 1;

    public Partie(IJoueur player, boolean isPrivate, int nbPlayers) {
        this.isPrivate = isPrivate;
        this.players = new ArrayList<IJoueur>();
        this.players.add(player);
        this.etatPartie = FabriqueEtatPartie.getInstance().getEtatPartieLobby(this);
        this.gameSize = nbPlayers;
        this.id = idGames++;
    }

    public void addPlayer(IJoueur player){
        etatPartie.addPlayer(player);
    }

    public int getGameSize() { return gameSize; }

    public List<IJoueur> getPlayers() { return players; }

    public void setPlayers(List<IJoueur> players) { this.players = players; }

    public int getId() { return id; }

    public boolean isPrivate() { return isPrivate; }


    @Override
    public String toString() {
        return "Partie{" +
                "players=" + players.toString() +
                ", etatPartie=" + etatPartie +
                ", gameSize=" + gameSize +
                ", isPrivate=" + isPrivate +
                ", id=" + id +
                '}';
    }
}
