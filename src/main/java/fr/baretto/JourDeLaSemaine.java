package fr.baretto;
import java.util.Scanner;

public class JourDeLaSemaine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Veuillez entrer un nombre entre 1 et 7 : ");
        int jour = scanner.nextInt();

        switch (jour) {
            case 1:
                System.out.println("Lundi");
                break;
            case 2:
                System.out.println("Mardi");
                break;
            case 3:
                System.out.println("Mercredi");
                break;
            case 4:
                System.out.println("Jeudi");
                break;
            case 5:
                System.out.println("Vendredi");
                break;
            case 6:
                System.out.println("Samedi");
                break;
            case 7:
                System.out.println("Dimanche");
                break;
            default:
                System.out.println("Le nombre saisi est invalide. Veuillez entrer un nombre entre 1 et 7.");
                break;
        }
        scanner.close();
    }
}
