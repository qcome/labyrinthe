package classes.cases;

import classes.plateau.IPlateau;

public interface ICase {
    public boolean isMovible();
    public IPlateau getBoard();
}
