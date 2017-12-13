package classes.plateau;

import classes.partie.IPartie;

public class FabriquePlateau {

    private static FabriquePlateau myBoard = null;

    private FabriquePlateau(){ }

    public static FabriquePlateau getInstance() {
        if (myBoard == null) {
            myBoard = new FabriquePlateau();
        }
        return myBoard;
    }

    public IPlateau createBoard(IPartie game) {
        return new Plateau(game);
    }
}
