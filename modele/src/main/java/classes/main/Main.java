package classes.main;

import classes.exceptions.*;
import classes.gestionnaire.Gestionnaire;
import classes.gestionnaire.IGestionnaire;
import classes.joueur.IJoueur;
import classes.partie.IPartie;

public class Main {

    public static void main(String[] args) {
        IGestionnaire gestionnaire = Gestionnaire.getInstance();

        try {
            gestionnaire.registration("douze", "pass", "pass");
            gestionnaire.registration("treize", "pass", "pass");
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
        int playerid = 0;
        try {
            playerid = gestionnaire.connection("douze", "pass");
            System.out.println(gestionnaire.getPlayerById(1).getPlayerState().isConnected());
            gestionnaire.connection("douze", "pass");
        } catch (UnknownPlayerException e) {
            System.out.println("EXCEPTION: joueur inconnu");
        } catch (PlayerAlreadyConnectedException e) {
            System.out.println("EXCEPTION: joueur deja connecté");
        }

        IPartie game = null;
        try {
            game = gestionnaire.createGame(playerid, true, 4);
        } catch (PlayerAlreadyInGameException e) {
            e.printStackTrace();
        }

        System.out.println(game);

        System.out.println("joueur connecté" + playerid);

    }
}
