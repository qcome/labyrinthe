package classes.main;

import classes.exceptions.*;
import classes.gestionnaire.Gestionnaire;
import classes.gestionnaire.IGestionnaire;
import classes.joueur.IJoueur;
import classes.partie.IPartie;

public class Main {



    public static void main(String[] args) {



        IGestionnaire gestionnaire = Gestionnaire.getInstance();

        int idPlayerOne = 0;
        int idPlayerTwo = 0;
        int idPlayerThree = 0;
        int idPlayerFour = 0;

        try {
            idPlayerOne = gestionnaire.registration("douze", "pass", "pass");
            idPlayerTwo = gestionnaire.registration("treize", "pass", "pass");
            idPlayerThree = gestionnaire.registration("quatorze", "pass", "pass");
            idPlayerFour = gestionnaire.registration("quinze", "pass", "pass");
            System.out.println(gestionnaire.getPlayerById(1).getPlayerState().isConnected());

        } catch (LoginAlreadyTakenException e) {
            System.out.println("EXCEPTION: Login déjà prit");
        } catch (PasswordConfirmationException e) {
            System.out.println("EXCEPTION: Probleme correspondance mots de passe");
        } catch (LoginTooShortException e) {
            System.out.println("EXCEPTION: Login trop court");
        } catch (PasswordTooShortException e) {
            System.out.println("EXCEPTION: Mot de passe trop court");
        }

        try {
            gestionnaire.connection("douze", "pass");
            gestionnaire.connection("treize", "pass");
            gestionnaire.connection("quatorze", "pass");
            gestionnaire.connection("quinze", "pass");
            System.out.println(gestionnaire.getPlayerById(1).getPlayerState().isConnected());
        } catch (UnknownPlayerException e) {
            System.out.println("EXCEPTION: joueur inconnu");
        } catch (PlayerAlreadyConnectedException e) {
            System.out.println("EXCEPTION: joueur deja connecté");
        }


        int idGameOne = 0;
        int idGameTwo = 0;
        try {
            idGameOne = gestionnaire.createGame(idPlayerOne, false, 2);
            //idGameTwo = gestionnaire.createGame(idPlayerTwo, false, 4);
        } catch (IncorrectNumberPlayerException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(idGameOne);
            System.out.println(idPlayerTwo);
            gestionnaire.sendInvitation(idGameOne, idPlayerTwo);
            //gestionnaire.sendInvitation(idGameOne, idPlayerThree);
        } catch (UnknownPlayerException e) {
            System.out.println("EXCEPTION: joueur inconnu / non connecté");
        } catch (PlayerAlreadyInGameException e) {
            System.out.println("EXCEPTION: joueur déjà dans une partie");
        }

        try {
            gestionnaire.acceptInvitation(idGameOne, idPlayerTwo);
            gestionnaire.acceptInvitation(idGameOne, idPlayerThree);
        } catch (GameAlreadyBegunException e) {
            System.out.println("EXCEPTION: partie déjà commencée");
        } catch (GameDoesntExistAnymoreException e) {
            System.out.println("EXCEPTION: La partie n'existe plus");
        }





    }
}
