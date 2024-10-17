package tp;

public class SumAllIntegers {

    public static int sumAll(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("La somme de tous les entiers de 1 à " + n + " est : " + sumAll(n));
    }
}
