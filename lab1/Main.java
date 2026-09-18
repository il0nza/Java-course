import java.util.Scanner;
import java.lang.Math;

public class Main {

    public double fraction(double x) {
        return x - (int) x;
    }

    public int charToNum(char x) {
        return x - '0';
    }

    public boolean is2Digits(int x) {
        return x >= 10 && x <= 99;
    }

    public boolean isInRange(int a, int b, int num) {
        if (a < b) {
            return num >= a && num <= b;
        } else {
            return num >= b && num <= a;
        }
    }

    public boolean isEqual(int a, int b, int c) {
        return a == b && b == c;
    }

    //
    public int abs(int x) {
        return abs(x);
    }

    public boolean is35(int x) {
        if ((x % 5 == 0) && (x % 3 == 0)) {
            return false;
        }
        if ((x % 5 == 0) || (x % 3 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public int max3(int x, int y, int z) {
        int max = x;
        if (y > max){
            max = y;
        }
        if (z > max){
            max = z;
        }
        return max;
    }

   

    public static void main(String[] args) {
        Main obj = new Main();
        Scanner sc = new Scanner(System.in);

        // Задание 1. Методы
        // 1
        System.out.print("Введите число: ");
        double i = sc.nextDouble();
        i = obj.fraction(i);
        System.out.println("Результат: " + i);

        // 3
        System.out.print("Введите цифру (от 0 до 9): ");
        char ch = sc.next().charAt(0);
        int c = obj.charToNum(ch);
        System.out.println("Результат: " + c);

        // 5
        System.out.print("Введите число: ");
        int n = sc.nextInt();
        System.out.println("Число двузначное: " + obj.is2Digits(n));

        // 7
        System.out.print("Введите границу диапазона a: ");
        int a = sc.nextInt();
        System.out.print("Введите границу диапазона b: ");
        int b = sc.nextInt();
        System.out.print("Введите число num: ");
        int num = sc.nextInt();
        System.out.println("num входит в указанный диапазон: " + obj.isInRange(a, b, num));

        // 9
        System.out.print("Введите число a: ");
        int a1 = sc.nextInt();
        System.out.print("Введите число b: ");
        int b1 = sc.nextInt();
        System.out.print("Введите число с: ");
        int c1 = sc.nextInt();
        System.out.println("Все три числа равны: " + obj.isEqual(a1, b1, c1));

        // Задание 2. Условия
        // 1
        System.out.print("Введите число: ");
        int a2 = sc.nextInt();
        System.out.println("Результат: " + obj.abs(a2));

        // 3
        System.out.print("Введите число x: ");
        int x = sc.nextInt();
        System.out.println("Результат: " + obj.is35(x));

        // 5
        System.out.print("Введите число x: ");
        int x1 = sc.nextInt();
        System.out.print("Введите число y: ");
        int y1 = sc.nextInt();
        System.out.print("Введите число z: ");
        int z1 = sc.nextInt();
        System.out.println("Максимальное число: " + obj.max3(x1, y1, z1));
        // 7

        // 9

        sc.close();
    }
}
