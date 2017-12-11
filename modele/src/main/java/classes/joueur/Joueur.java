package classes.joueur;

import classes.Couleur;
import classes.Partie;

import java.util.Hashtable;
import java.util.Map;

//done

public class Joueur implements IJoueur{

    private String login;
    private String password;
    private Couleur color;
    private int id;
    private Map invitations;

    private static int idPlayers = 0;

    public Joueur(String login, String password) {
        this.login = login;
        this.password = password;
        this.color = null;
        this.invitations = new Hashtable<String, Partie>();
        this.id = idPlayers++;
    }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Couleur getColor() { return color; }

    public void setColor(Couleur color) { this.color = color; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }
}
