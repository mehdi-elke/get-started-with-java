package tp2;

public class Dish {
    private String nom;
    public enum Taille {
        S,
        M,
        L
    }
    private Taille taille;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    

    public Dish(String nom, Taille taille) {
        this.nom = nom;
        this.taille = taille;
    }

}
