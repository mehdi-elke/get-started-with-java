package bibliothque;

public class Bibliotheque {
    private String title;
    private String author;
    private Integer yearPublished;
    private Double price;


    public Bibliotheque(String title, String author, Integer yearPublished, Double price) {
        if (yearPublished == null || price == null) {
            throw new IllegalArgumentException("L'année de publication et le prix ne peuvent pas être nuls.");
        }
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Bibliotheque book = (Bibliotheque) obj;
        return title.equals(book.title) && author.equals(book.author);
    }


    @Override
    public String toString() {
        return "Titre: " + title + ", Auteur: " + author + ", Année de publication: " + yearPublished + ", Prix: " + price + "€";
    }


    public void applyDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Le pourcentage de réduction doit être entre 0 et 100.");
        }
        this.price -= this.price * (percentage / 100);
    }


    public static Bibliotheque comparePublicationYear(Bibliotheque book1, Bibliotheque book2) {
        if (book1.yearPublished >= book2.yearPublished) {
            return book1;
        } else {
            return book2;
        }
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public Double getPrice() {
        return price;
    }
}
