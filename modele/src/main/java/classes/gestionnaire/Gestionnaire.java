package classes.gestionnaire;

import classes.exceptions.*;
import classes.joueur.FabriqueEtatJoueur;
import classes.joueur.FabriqueJoueur;
import classes.joueur.IJoueur;
import classes.partie.FabriquePartie;
import classes.partie.IPartie;

import java.util.Hashtable;
import java.util.Map;

public class Gestionnaire implements IGestionnaire{

    private static Gestionnaire instance;

    private Map<Integer, IJoueur> mapPlayers;
    private Map<Integer, IPartie> mapGames;

    public static Gestionnaire getInstance(){
        if(instance == null){
            instance = new Gestionnaire();
        }
        return instance;
    }

    private Gestionnaire() {
        mapPlayers = new Hashtable<Integer, IJoueur>();
        mapGames = new Hashtable<Integer, IPartie>();
    }

    public int registration(String login, String password, String passwordConfirmation) throws LoginAlreadyTakenException, LoginTooShortException, PasswordConfirmationException, PasswordTooShortException {
        if (login.length() < 4)
            throw new LoginTooShortException();
        if (!password.equals(passwordConfirmation))
            throw new PasswordConfirmationException();
        if (password.length() < 4)
            throw new PasswordTooShortException();
        for(IJoueur player: this.mapPlayers.values())
            if (player.getLogin().equals(login))
                throw new LoginAlreadyTakenException();
        IJoueur player = FabriqueJoueur.getInstance().createPlayer(login, password);
        mapPlayers.put(player.getId(), player);
        return player.getId();
    }

    public int connection(String login, String password) throws UnknownPlayerException, PlayerAlreadyConnectedException {
        for(IJoueur player: this.mapPlayers.values()) {
            if(player.getLogin().equals(login) && player.getPassword().equals(password)) {
                getPlayerById(player.getId()).connection();
                return player.getId();
            }
        }
        throw new UnknownPlayerException();
    }

    public IPartie createGame(int idPlayer, boolean isPrivate, int gameSize) throws PlayerAlreadyInGameException {
        IJoueur player = getPlayerById(idPlayer);
        IPartie game = FabriquePartie.getInstance().createGame(player, isPrivate, gameSize);
        getPlayerById(player.getId()).joinGame(game);
        mapGames.put(game.getId(), game);
        return game;
    }

    public void sendInvitation(IPartie game, int idPlayer, int idInvitedPlayer){

    }

    public Map<Integer, IJoueur> getMapPlayers() { return mapPlayers; }

    public IJoueur getPlayerById(int id){ return mapPlayers.get(id); }







}
