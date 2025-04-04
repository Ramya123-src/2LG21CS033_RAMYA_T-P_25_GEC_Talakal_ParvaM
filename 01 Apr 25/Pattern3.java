import java.util.*;

public class Pattern3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int c = sc.nextInt();

        System.out.println("center aligned pyramid:");
        for (int i = 1; i <= c; i++) {
            for (int k = 1; k <= c - i; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(10);
            }

            System.out.println();
        }

        System.out.println("left aligned pyramid:");
        for (int i = 1; i <= c; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(10 + " ");
            }

            System.out.println();
        }

        System.out.println("right aligned pyramid:");
        for (int i = 1; i <= c; i++) {
            for (int k = 1; k <= c - i; k++) {
                System.out.print(" " + " ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(10);
            }

            System.out.println();
        }

        sc.close();
    }
}