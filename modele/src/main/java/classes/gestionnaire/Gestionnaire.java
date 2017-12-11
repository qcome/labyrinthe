package classes.gestionnaire;

import classes.exceptions.LoginAlreadyTakenException;
import classes.exceptions.LoginTooShortException;
import classes.exceptions.PasswordConfirmationException;
import classes.exceptions.PasswordTooShortException;
import classes.joueur.FabriqueJoueur;
import classes.joueur.IJoueur;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Gestionnaire implements IGestionnaire{

    private static Gestionnaire instance;

    private List<IJoueur> listPlayers;

    public static Gestionnaire getInstance(){
        if(instance == null){
            instance = new Gestionnaire();
        }
        return instance;
    }

    private Gestionnaire() {
        listPlayers = new ArrayList<IJoueur>();
    }

    public int registration(String login, String password, String passwordConfirmation) throws LoginAlreadyTakenException, LoginTooShortException, PasswordConfirmationException, PasswordTooShortException {
        if (login.length() < 4)
            throw new LoginTooShortException();
        if (!password.equals(passwordConfirmation))
            throw new PasswordConfirmationException();
        if (password.length() < 4)
            throw new PasswordTooShortException();
        for(IJoueur player: this.listPlayers)
            if (player.getLogin().equals(login))
                throw new LoginAlreadyTakenException();
        IJoueur player = FabriqueJoueur.getInstance().createPlayer(login, password);
        listPlayers.add(player);
        return player.getId();
    }

    public List<IJoueur> getListPlayers() { return listPlayers; }





}
