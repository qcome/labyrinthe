package classes.partie;

import classes.exceptions.GameAlreadyBegunException;
import classes.joueur.IJoueur;
import classes.plateau.FabriquePlateau;
import classes.plateau.IPlateau;

public class EtatPartieEnCours implements EtatPartie{
    IPartie game;
    private IPlateau board;
    public EtatPartieEnCours(IPartie game) {
        this.board = FabriquePlateau.getInstance().createBoard(game);
        this.game = game;
    }

    public void addPlayer(IJoueur player) throws GameAlreadyBegunException {
        throw new GameAlreadyBegunException();
    }

    public boolean hasBegun() { return true; }

    public boolean isEnded() {
        return false;
    }

    public IPlateau getBoard() {
        return this.board;
    }


    public String getGameStateMsg() {
        return "Partie en cours";
    }
}
