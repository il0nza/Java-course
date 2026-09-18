import java.util.Scanner;

public class Main {
    void printTable() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " * " + j + " = " + i * j);
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        // int, boolean, double, char - primitive
        // String, Arrays, List - reference

        Main obj = new Main();
        obj.printTable();

        // String str = new String("String");
        // System.out.println(str);
        // System.out.println(args[0]);

        System.out.print("Введите число: ");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(i);
        sc.close(); 
    }
}