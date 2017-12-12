package classes.partie;

public class FabriqueEtatPartie {

    private static FabriqueEtatPartie myGameState = null;

    private FabriqueEtatPartie(){
    }

    public static FabriqueEtatPartie getInstance() {
        if (myGameState == null) {
            myGameState = new FabriqueEtatPartie();
        }
        return myGameState;
    }

    public EtatPartie getEtatPartieLobby(IPartie p) {
        return new EtatPartieLobby(p);
    }
}
