package classes.plateau;

import classes.cases.FabriqueCase;
import classes.cases.ICase;
import classes.cases.TypeCase;
import classes.modele.Coordonnees;
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
        board[0][0] = caseFactory.getCaseTresor(TypeCase.L, TypeTresor.ARAIGNEE, new Coordonnees(0, 0));
        board[1][1] = caseFactory.getCaseSimple(TypeCase.T, new Coordonnees(1, 1));
        //board[0][1] = caseFactory.getCaseSimple()
        System.out.println(board[0][0]);
        System.out.println(board[1][1]);

    }





}
