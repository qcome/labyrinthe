package classes.main;

import classes.exceptions.LoginAlreadyTakenException;
import classes.exceptions.LoginTooShortException;
import classes.exceptions.PasswordConfirmationException;
import classes.exceptions.PasswordTooShortException;
import classes.gestionnaire.Gestionnaire;
import classes.gestionnaire.IGestionnaire;
import classes.joueur.IJoueur;

public class Main {

    public static void main(String[] args) {
        IGestionnaire gestionnaire = Gestionnaire.getInstance();

        try {
            gestionnaire.registration("mir", "uze", "uze");

        } catch (LoginAlreadyTakenException e) {
            System.out.println("Login déjà prit");
        } catch (PasswordConfirmationException e) {
            System.out.println("Probleme correspondance mots de passe");
        } catch (LoginTooShortException e) {
            System.out.println("Login trop court");
        } catch (PasswordTooShortException e) {
            System.out.println("Mot de passe trop court");
        }


    }
}
