package classes.partie;

import classes.joueur.IJoueur;

import java.util.List;

public class EtatPartieLobby implements EtatPartie{

    IPartie game;
    public EtatPartieLobby(IPartie game) {
        this.game = game;
    }
    public void addPlayer(IJoueur player){
        List<IJoueur> players = this.game.getPlayers();
        players.add(player);
        this.game.setPlayers(players);
        //change l'etat de la partie si le nombre de joueur de la partie est présent
        if(players.size() == this.game.getGameSize())
            this.game.setGameState(FabriqueEtatPartie.getInstance().getEtatPartieEnCours(this.game));
    }

    public boolean hasBegun() { return false; }
}
