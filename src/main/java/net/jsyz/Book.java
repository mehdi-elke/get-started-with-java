package net.jsyz;

public class Book {

    String titre;
    String auteur;
    int yearPublished;
    int prix;

    public Book(String titre, String auteur, int yearPublished, int prix) {
        this.titre = titre;
        this.auteur = auteur;
        this.yearPublished = yearPublished;
        this.prix = prix;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return titre.equals(book.titre) && auteur.equals(book.auteur);
    }

    @Override
    public String toString() {
        return "Book{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", yearPublished=" + yearPublished +
                ", prix=" + prix +
                '}';
    }

    public void applyDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Percentage must be between 0 and 100");
        }
        this.prix -= (int) (this.prix * percentage / 100);
    }

    public static Book comparePublicationYear(Book book1, Book book2) {
        return book1.yearPublished > book2.yearPublished ? book1 : book2;
    }
}