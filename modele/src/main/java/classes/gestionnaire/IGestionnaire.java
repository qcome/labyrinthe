package classes.gestionnaire;

import classes.exceptions.LoginAlreadyTakenException;
import classes.exceptions.LoginTooShortException;
import classes.exceptions.PasswordConfirmationException;
import classes.exceptions.PasswordTooShortException;
import classes.joueur.IJoueur;

import java.util.List;

public interface IGestionnaire {
    public int registration(String login, String password, String passwordConfirmation) throws LoginAlreadyTakenException, LoginTooShortException, PasswordConfirmationException, PasswordTooShortException;
    public List<IJoueur> getListPlayers();
}
