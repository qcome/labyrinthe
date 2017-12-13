package classes.plateau;

import classes.cases.FabriqueCase;
import classes.cases.ICase;
import classes.cases.TypeCase;
import classes.modele.Coordonnees;
import classes.modele.Direction;
import classes.partie.IPartie;
import classes.tresor.TypeTresor;

import java.util.Arrays;

public class Plateau implements IPlateau{

    private IPartie game;
    private ICase[][] board;

    public Plateau(IPartie game) {
        this.game = game;
        this.board = new ICase[7][7];
        FabriqueCase caseFactory = FabriqueCase.getInstance();
        //initialisation plateau

        board[0][0] = caseFactory.getCaseSimple(TypeCase.L, Direction.G, new Coordonnees(0, 0), this);
        board[0][2] = caseFactory.getCaseTresor(TypeCase.T, Direction.B, TypeTresor.SALAMANDRE, new Coordonnees(0, 2), this);
        board[0][4] = caseFactory.getCaseTresor(TypeCase.T, Direction.B, TypeTresor.COFFRE, new Coordonnees(0, 4), this);
        //board[0][1] = caseFactory.getCaseSimple()
        
        System.out.println(Arrays.toString(board[0]));


    }





}
