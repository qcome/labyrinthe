package classes.joueur;

import classes.Couleur;
import classes.Partie;
import classes.exceptions.PlayerAlreadyConnectedException;
import classes.exceptions.PlayerAlreadyInGameException;
import classes.partie.IPartie;

import java.util.Hashtable;
import java.util.Map;


public class Joueur implements IJoueur{

    private String login;
    private String password;
    private Couleur color;
    private int id;
    private Map invitations;

    private EtatJoueur playerState;

    private static int idPlayers = 1;

    public Joueur(String login, String password) {
        this.login = login;
        this.password = password;
        this.color = null;
        this.invitations = new Hashtable<String, Partie>();
        this.id = idPlayers++;
        this.playerState = FabriqueEtatJoueur.getInstance().getEtatJoueurNonConnecte(this);
    }

    public void connection() throws PlayerAlreadyConnectedException {
        this.playerState.connection();
    }

    public void joinGame(IPartie game) throws PlayerAlreadyInGameException {
        this.playerState.joinGame(game);
    }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Couleur getColor() { return color; }

    public void setColor(Couleur color) { this.color = color; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public EtatJoueur getPlayerState() { return playerState; }

    public void setPlayerState(EtatJoueur playerState) { this.playerState = playerState; }

    @Override
    public String toString() {
        return "Joueur{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", color=" + color +
                ", id=" + id +
                ", invitations=" + invitations +
                '}';
    }
}
