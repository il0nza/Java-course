import java.util.Scanner;
import java.lang.Math;

public class Main {
    // Вспомогательные методы для проверки ввода
    private int readInt(Scanner sc, String p) {
        while (true) {
            System.out.print(p);
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.println("Ошибка! Введите целое число.");
                sc.next();
            }
        }
    }

    private double readDouble(Scanner sc, String p) {
        while (true) {
            System.out.print(p);
            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            } else {
                System.out.println("Ошибка! Введите дробное число через запятую.");
                sc.next();
            }
        }
    }

    private char readChar(Scanner sc, String p) {
        while (true) {
            System.out.print(p);
            String input = sc.next();
            if (input.length() == 1) {
                return input.charAt(0);
            } else {
                System.out.println("Ошибка! Введите ровно один символ.");
            }
        }
    }

    // Задание 1
    public double fraction(double x) {
        return Math.abs(x) - (int) Math.abs(x);
    }

    public int charToNum(char x) {
        return x - '0';
    }

    public boolean is2Digits(int x) {
        return Math.abs(x) >= 10 && Math.abs(x) <= 99;
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

    // Задание 2
    public int abs(int x) {
        return Math.abs(x);
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
        if (y > max) {
            max = y;
        }
        if (z > max) {
            max = z;
        }
        return max;
    }

    public int sum2(int x, int y) {
        if (10 <= x + y && x + y <= 19) {
            return 20;
        }
        return x + y;
    }

    public String day(int x) {
        switch (x) {
            case 1:
                return "понедельник";
            case 2:
                return "вторник";
            case 3:
                return "среда";
            case 4:
                return "четверг";
            case 5:
                return "пятница";
            case 6:
                return "суббота";
            case 7:
                return "воскресенье";
            default:
                return "это не день недели";
        }
    }

    // Задание 3
    public String listNums(int x) {
        String s = "";
        for (int i = 0; i <= x; i++) {
            s += " " + i;
        }
        return s;
    }

    public String chet(int x) {
        String s = "";
        for (int i = 0; i <= x; i += 2) {
            s += " " + i;
        }
        return s;
    }

    public int numLen(long x) {
        if (x == 0) {
            return 1;
        }
        int c = 0;
        long absX = Math.abs(x);
        while (absX != 0) {
            absX /= 10;
            c++;
        }
        return c;
    }

    public void square(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void rightTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= x - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Задание 4
    public void fillArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 101) - 50;
        }
        System.out.print("Элементы массива: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public int maxAbs(int[] arr) {
        int max = arr[0];
        int maxAbs = Math.abs(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > maxAbs) {
                maxAbs = Math.abs(arr[i]);
                max = arr[i];
            }
        }
        return max;
    }

    public int[] add(int[] arr, int[] ins, int pos) {
        int[] newArr = new int[arr.length + ins.length];
        for (int i = 0; i < pos; i++) {
            newArr[i] = arr[i];
        }
        for (int i = 0; i < ins.length; i++) {
            newArr[pos + i] = ins[i];
        }
        for (int i = pos; i < arr.length; i++) {
            newArr[i + ins.length] = arr[i];
        }
        return newArr;
    }

    public int[] reverseBack(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[arr.length - i - 1];
        }
        return newArr;
    }

    public int[] findAll(int[] arr, int x) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++;
            }
        }
        int[] res = new int[count];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                res[k] = i;
                k++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Main obj = new Main();
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        int choice;
        while (run) {
            System.out.print("""
                    Выберите задание:
                        1 - Задание 1. Методы
                        2 - Задание 2. Условия
                        3 - Задание 3. Циклы
                        4 - Задание 4. Массивы
                        0 - Выход
                    >>  """);
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    // Задание 1. Методы
                    // 1
                    System.out.println("\nДробная часть");
                    double i = obj.readDouble(sc, "Введите число: ");
                    System.out.println("Результат: " + obj.fraction(i));

                    // 3
                    System.out.println("\nБукву в число");
                    char ch = obj.readChar(sc, "Введите цифру (от 0 до 9): ");
                    System.out.println("Результат: " + obj.charToNum(ch));

                    // 5
                    System.out.println("\nДвузначное");
                    int n = obj.readInt(sc, "Введите число: ");
                    System.out.println("Число двузначное: " + obj.is2Digits(n));

                    // 7
                    System.out.println("\nДиапазон");
                    int a = obj.readInt(sc, "Введите границу диапазона a: ");
                    int b = obj.readInt(sc, "Введите границу диапазона b: ");
                    int num = obj.readInt(sc, "Введите число num: ");
                    System.out.println("num входит в указанный диапазон: " + obj.isInRange(a, b, num));

                    // 9
                    System.out.println("\nРавенство");
                    int a1 = obj.readInt(sc, "Введите число a: ");
                    int b1 = obj.readInt(sc, "Введите число b: ");
                    int c1 = obj.readInt(sc, "Введите число c: ");
                    System.out.println("Все три числа равны: " + obj.isEqual(a1, b1, c1));
                    break;
                }
                case 2: {
                    // Задание 2. Условия
                    // 1
                    System.out.println("\nМодуль числа");
                    int a2 = obj.readInt(sc, "Введите число: ");
                    System.out.println("Результат: " + obj.abs(a2));

                    // 3
                    System.out.println("\nТридцать пять");
                    int x = obj.readInt(sc, "Введите число x: ");
                    System.out.println("Результат: " + obj.is35(x));

                    // 5
                    System.out.println("\nТройной максимум");
                    int x1 = obj.readInt(sc, "Введите число x: ");
                    int y1 = obj.readInt(sc, "Введите число y: ");
                    int z1 = obj.readInt(sc, "Введите число z: ");
                    System.out.println("Максимальное число: " + obj.max3(x1, y1, z1));

                    // 7
                    System.out.println("\nДвойная сумма");
                    int x2 = obj.readInt(sc, "Введите число x: ");
                    int y2 = obj.readInt(sc, "Введите число y: ");
                    System.out.println("Сумма: " + obj.sum2(x2, y2));

                    // 9
                    System.out.println("\nДень недели");
                    int d = obj.readInt(sc, "Введите число: ");
                    System.out.println("Результат: " + obj.day(d));
                    break;
                }
                case 3: {
                    // Задание 3. Циклы
                    // 1
                    System.out.println("\nЧисла подряд");
                    int n = obj.readInt(sc, "Введите число: ");
                    System.out.println("Результат: " + obj.listNums(n));

                    // 3
                    System.out.println("\nЧетные числа от 0 до x");
                    int n1 = obj.readInt(sc, "Введите число x: ");
                    System.out.println("Результат: " + obj.chet(n1));

                    // 5
                    System.out.println("\nДлина числа");
                    int n2 = obj.readInt(sc, "Введите число x: ");
                    System.out.println("Результат: " + obj.numLen(n2));

                    // 7
                    System.out.println("\nКвадрат");
                    int n3 = obj.readInt(sc, "Введите число x: ");
                    obj.square(n3);

                    // 9
                    System.out.println("\nПравый треугольник");
                    int n4 = obj.readInt(sc, "Введите число x: ");
                    obj.rightTriangle(n4);
                    break;
                }
                case 4: {
                    // Задание 4. Массивы
                    int l = obj.readInt(sc, "Введите длину основного массива: ");
                    int[] arr = new int[l];
                    obj.fillArr(arr);

                    // 1
                    System.out.println("\nПоиск первого значения");
                    int m = obj.readInt(sc, "Введите число x: ");
                    System.out.println("Результат: " + obj.findFirst(arr, m));

                    // 3
                    System.out.println("\nПоиск максимального");
                    System.out.println("Результат: " + obj.maxAbs(arr));

                    // 5
                    System.out.println("\nДобавление массива в массив");
                    int l1 = obj.readInt(sc, "Введите длину дополнительного массива: ");
                    int[] arr1 = new int[l1];
                    obj.fillArr(arr1);

                    int pos;
                    while (true) {
                        pos = obj.readInt(sc, "Введите в какую позицию pos вставить второй массив: ");
                        if (pos >= 0 && pos <= arr.length) {
                            break;
                        }
                        System.out.println("Неверная позиция! Допустимый диапазон: от 0 до " + arr.length);
                    }
                    int[] res = obj.add(arr, arr1, pos);
                    System.out.print("Результат: ");
                    for (int i = 0; i < res.length; i++) {
                        System.out.print(res[i] + " ");
                    }
                    System.out.println();

                    // 7
                    System.out.println("\nВозвратный реверс основного массива");
                    int[] res1 = obj.reverseBack(arr);
                    System.out.print("Результат: ");
                    for (int i = 0; i < res1.length; i++) {
                        System.out.print(res1[i] + " ");
                    }
                    System.out.println();

                    // 9
                    System.out.println("\nВсе вхождения");
                    int m1 = obj.readInt(sc, "Введите число x из основного массива: ");
                    int[] res2 = obj.findAll(arr, m1);
                    System.out.print("Результат: ");
                    for (int i = 0; i < res2.length; i++) {
                        System.out.print(res2[i] + " ");
                    }
                    System.out.println();
                    break;
                }
                case 0: {
                    run = false;
                    break;
                }
                default:
                    System.out.println("Некорректный ввод. Попробуйте снова");
            }
        }
        sc.close();
    }
}
