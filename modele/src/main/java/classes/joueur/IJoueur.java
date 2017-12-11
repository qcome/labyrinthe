package classes.joueur;

import classes.Couleur;

import java.io.Serializable;

public interface IJoueur extends Serializable{
    public String getLogin();
    public void setLogin(String login);
    public String getPassword();
    public void setPassword(String password);
    public Couleur getColor();
    public void setColor(Couleur color);
    public int getId();
    public void setId(int id);
}
