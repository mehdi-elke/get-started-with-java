package tp2;

public class Dish {
    private String nom;
    private enum Taille {
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

    public Taille getTaille() {
        return taille;
    }

    public void setTaille(Taille taille) {
        this.taille = taille;
    }

    public Dish(String nom, Taille taille) {
        this.nom = nom;
        this.taille = taille;
    }

}
