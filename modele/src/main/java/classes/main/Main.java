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

        try {
            idPlayerOne = gestionnaire.registration("douze", "pass", "pass");
            idPlayerTwo = gestionnaire.registration("treize", "pass", "pass");
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
            System.out.println(gestionnaire.getPlayerById(1).getPlayerState().isConnected());
        } catch (UnknownPlayerException e) {
            System.out.println("EXCEPTION: joueur inconnu");
        } catch (PlayerAlreadyConnectedException e) {
            System.out.println("EXCEPTION: joueur deja connecté");
        }



        int idGameOne = gestionnaire.createGame(idPlayerOne, false, 4);
        int idGameTwo = gestionnaire.createGame(idPlayerTwo, false, 4);
        try {
            gestionnaire.sendInvitation(idGameOne, idPlayerTwo);
        } catch (UnknownPlayerException e) {
            System.out.println("EXCEPTION: joueur inconnu / non connecté");
        } catch (PlayerAlreadyInGameException e) {
            System.out.println("EXCEPTION: joueur déjà dans une partie");
        }


        



    }
}
