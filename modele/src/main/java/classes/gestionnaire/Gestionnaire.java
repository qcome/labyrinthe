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

    public int createGame(int idPlayer, boolean isPrivate, int gameSize) throws IncorrectNumberPlayerException {
        if(gameSize <= 1 || gameSize >= 5)
            throw new IncorrectNumberPlayerException();
        IJoueur player = getPlayerById(idPlayer);
        IPartie game = FabriquePartie.getInstance().createGame(player, isPrivate, gameSize);
        getPlayerById(player.getId()).joinGame(game);
        mapGames.put(game.getId(), game);
        return game.getId();
    }

    public void sendInvitation(int idGame, int idInvitedPlayer) throws UnknownPlayerException, PlayerAlreadyInGameException {
        IPartie game = getGameById(idGame);
        IJoueur player = game.getGameCreator();
        IJoueur invitedPlayer = getPlayerById(idInvitedPlayer);
        player.sendInvitation(invitedPlayer, game);
    }

    public void acceptInvitation(int idGame, int idPlayer) throws GameAlreadyBegunException, GameDoesntExistAnymoreException {
        IPartie game = getGameById(idGame);
        IJoueur player = getPlayerById(idPlayer);
        game.addPlayer(player);
    }

    public Map<Integer, IJoueur> getMapPlayers() { return mapPlayers; }

    public IJoueur getPlayerById(int id){ return mapPlayers.get(id); }

    public IPartie getGameById(int id){ return mapGames.get(id);}







}
