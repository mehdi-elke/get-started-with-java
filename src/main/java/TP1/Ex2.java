package TP1;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un nombre entre 1 et 7 : ");
        int jour = scanner.nextInt();
        String jourSemaine = switch (jour) {
            case 1 -> "Lundi";
            case 2 -> "Mardi";
            case 3 -> "Mercredi";
            case 4 -> "Jeudi";
            case 5 -> "Vendredi";
            case 6 -> "Samedi";
            case 7 -> "Dimanche";
            default -> "Chef choisis un nombre entre 1 et 7.";
        };

        System.out.println(jourSemaine);
    }
}
