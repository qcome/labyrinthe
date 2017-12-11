package classes;

public enum Couleur {

    RED("Couleur rouge"),
    BLUE("Couleur bleue"),
    YELLOW("Couleur jaune"),
    GREEN("Couleur verte");

    private String color = "";

    Couleur(String color) {
        this.color = color;
    }

    public String toString(){
        return color;
    }

}
